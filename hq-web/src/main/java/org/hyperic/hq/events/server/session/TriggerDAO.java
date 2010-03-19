/*
 * NOTE: This copyright doesnot cover user programs that use HQ program services
 * by normal system calls through the application program interfaces provided as
 * part of the Hyperic Plug-in Development Kit or the Hyperic Client Development
 * Kit - this is merely considered normal use of the program, and doesnot fall
 * under the heading of "derived work". Copyright (C) [2004-2008], Hyperic, Inc.
 * This file is part of HQ. HQ is free software; you can redistribute it and/or
 * modify it under the terms version 2 of the GNU General Public License as
 * published by the Free Software Foundation. This program is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See
 * the GNU General Public License for more details. You should have received a
 * copy of the GNU General Public License along with this program; if not, write
 * to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 * 02111-1307 USA.
 */
package org.hyperic.hq.events.server.session;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.dialect.Dialect;
import org.hyperic.hibernate.Util;
import org.hyperic.hq.dao.HibernateDAO;
import org.hyperic.hq.events.shared.RegisteredTriggerValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class TriggerDAO
    extends HibernateDAO<RegisteredTrigger> implements TriggerDAOInterface
{
    @Autowired
    public TriggerDAO(SessionFactory sessionFactory) {
        super(RegisteredTrigger.class, sessionFactory);
    }

    public RegisteredTrigger create(RegisteredTriggerValue createInfo) {
        RegisteredTrigger res = new RegisteredTrigger(createInfo);
        save(res);

        // Set the new ID just in case someone wants to use it
        createInfo.setId(res.getId());

        return res;
    }

    public void removeTriggers(AlertDefinition def) {

        String sql = "update AlertCondition set trigger = null " + "where alertDefinition = :def";

        getSession().createQuery(sql).setParameter("def", def).executeUpdate();

        def.clearTriggers();
    }

    public void deleteAlertDefinition(AlertDefinition def) {
        String sql = "update AlertCondition c set trigger = null " + "where alertDefinition = :def or "
                     + "exists (select d.id from AlertDefinition d where "
                     + "d.parent = :def and c.alertDefinition = d)";

        getSession().createQuery(sql).setParameter("def", def).executeUpdate();

        sql = "delete from RegisteredTrigger r " + "where alertDefinition = :def or "
              + "exists (select d.id from AlertDefinition d where " + "d.parent = :def and r.alertDefinition = d)";

        getSession().createQuery(sql).setParameter("def", def).executeUpdate();
    }

    public RegisteredTrigger findById(Integer id) {
        return (RegisteredTrigger) super.findById(id);
    }

    public RegisteredTrigger get(Integer id) {
        return (RegisteredTrigger) super.get(id);
    }

    /**
     * Find all the registered triggers associated with the alert definition.
     *
     * @param id The alert definition id.
     * @return The list of associated registered triggers.
     */
    @SuppressWarnings("unchecked")
    public List<RegisteredTrigger> findByAlertDefinitionId(Integer id) {
        String sql = "from RegisteredTrigger rt where rt.alertDefinition.id = :defId";

        return getSession().createQuery(sql).setParameter("defId", id).list();
    }


    @SuppressWarnings("unchecked")
    public Set<RegisteredTrigger> findAllEnabledTriggers() {
        Dialect dialect = Util.getDialect();
        //For performance optimization, we want to fetch each trigger's alert def as well as the alert def's conditions in a single query (as they will be used to create AlertConditionEvaluators when creating trigger impls).
        //This query guarantees that when we do trigger.getAlertDefinition().getConditions(), the database is not hit again
        String hql = new StringBuilder().append("from AlertDefinition ad left join fetch ad.conditionsBag c inner join fetch c.trigger where ad.enabled = ")
                                        .append(dialect.toBooleanValueString(true))
                                        .toString();
        List<AlertDefinition> alertDefs = getSession().createQuery(hql).list();
        Set<RegisteredTrigger> triggers = new LinkedHashSet<RegisteredTrigger>();
        for(AlertDefinition definition : alertDefs) {
            for(AlertCondition condition: definition.getConditionsBag()) {
                triggers.add(condition.getTrigger());
            }
        }
        return triggers;
    }

}