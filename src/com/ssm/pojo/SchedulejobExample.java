package com.ssm.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SchedulejobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SchedulejobExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andScdUuidIsNull() {
            addCriterion("scd_uuid is null");
            return (Criteria) this;
        }

        public Criteria andScdUuidIsNotNull() {
            addCriterion("scd_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andScdUuidEqualTo(String value) {
            addCriterion("scd_uuid =", value, "scdUuid");
            return (Criteria) this;
        }

        public Criteria andScdUuidNotEqualTo(String value) {
            addCriterion("scd_uuid <>", value, "scdUuid");
            return (Criteria) this;
        }

        public Criteria andScdUuidGreaterThan(String value) {
            addCriterion("scd_uuid >", value, "scdUuid");
            return (Criteria) this;
        }

        public Criteria andScdUuidGreaterThanOrEqualTo(String value) {
            addCriterion("scd_uuid >=", value, "scdUuid");
            return (Criteria) this;
        }

        public Criteria andScdUuidLessThan(String value) {
            addCriterion("scd_uuid <", value, "scdUuid");
            return (Criteria) this;
        }

        public Criteria andScdUuidLessThanOrEqualTo(String value) {
            addCriterion("scd_uuid <=", value, "scdUuid");
            return (Criteria) this;
        }

        public Criteria andScdUuidLike(String value) {
            addCriterion("scd_uuid like", value, "scdUuid");
            return (Criteria) this;
        }

        public Criteria andScdUuidNotLike(String value) {
            addCriterion("scd_uuid not like", value, "scdUuid");
            return (Criteria) this;
        }

        public Criteria andScdUuidIn(List<String> values) {
            addCriterion("scd_uuid in", values, "scdUuid");
            return (Criteria) this;
        }

        public Criteria andScdUuidNotIn(List<String> values) {
            addCriterion("scd_uuid not in", values, "scdUuid");
            return (Criteria) this;
        }

        public Criteria andScdUuidBetween(String value1, String value2) {
            addCriterion("scd_uuid between", value1, value2, "scdUuid");
            return (Criteria) this;
        }

        public Criteria andScdUuidNotBetween(String value1, String value2) {
            addCriterion("scd_uuid not between", value1, value2, "scdUuid");
            return (Criteria) this;
        }

        public Criteria andCsdCronIsNull() {
            addCriterion("csd_cron is null");
            return (Criteria) this;
        }

        public Criteria andCsdCronIsNotNull() {
            addCriterion("csd_cron is not null");
            return (Criteria) this;
        }

        public Criteria andCsdCronEqualTo(String value) {
            addCriterion("csd_cron =", value, "csdCron");
            return (Criteria) this;
        }

        public Criteria andCsdCronNotEqualTo(String value) {
            addCriterion("csd_cron <>", value, "csdCron");
            return (Criteria) this;
        }

        public Criteria andCsdCronGreaterThan(String value) {
            addCriterion("csd_cron >", value, "csdCron");
            return (Criteria) this;
        }

        public Criteria andCsdCronGreaterThanOrEqualTo(String value) {
            addCriterion("csd_cron >=", value, "csdCron");
            return (Criteria) this;
        }

        public Criteria andCsdCronLessThan(String value) {
            addCriterion("csd_cron <", value, "csdCron");
            return (Criteria) this;
        }

        public Criteria andCsdCronLessThanOrEqualTo(String value) {
            addCriterion("csd_cron <=", value, "csdCron");
            return (Criteria) this;
        }

        public Criteria andCsdCronLike(String value) {
            addCriterion("csd_cron like", value, "csdCron");
            return (Criteria) this;
        }

        public Criteria andCsdCronNotLike(String value) {
            addCriterion("csd_cron not like", value, "csdCron");
            return (Criteria) this;
        }

        public Criteria andCsdCronIn(List<String> values) {
            addCriterion("csd_cron in", values, "csdCron");
            return (Criteria) this;
        }

        public Criteria andCsdCronNotIn(List<String> values) {
            addCriterion("csd_cron not in", values, "csdCron");
            return (Criteria) this;
        }

        public Criteria andCsdCronBetween(String value1, String value2) {
            addCriterion("csd_cron between", value1, value2, "csdCron");
            return (Criteria) this;
        }

        public Criteria andCsdCronNotBetween(String value1, String value2) {
            addCriterion("csd_cron not between", value1, value2, "csdCron");
            return (Criteria) this;
        }

        public Criteria andScdLastRunTimeIsNull() {
            addCriterion("scd_last_run_time is null");
            return (Criteria) this;
        }

        public Criteria andScdLastRunTimeIsNotNull() {
            addCriterion("scd_last_run_time is not null");
            return (Criteria) this;
        }

        public Criteria andScdLastRunTimeEqualTo(Date value) {
            addCriterion("scd_last_run_time =", value, "scdLastRunTime");
            return (Criteria) this;
        }

        public Criteria andScdLastRunTimeNotEqualTo(Date value) {
            addCriterion("scd_last_run_time <>", value, "scdLastRunTime");
            return (Criteria) this;
        }

        public Criteria andScdLastRunTimeGreaterThan(Date value) {
            addCriterion("scd_last_run_time >", value, "scdLastRunTime");
            return (Criteria) this;
        }

        public Criteria andScdLastRunTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("scd_last_run_time >=", value, "scdLastRunTime");
            return (Criteria) this;
        }

        public Criteria andScdLastRunTimeLessThan(Date value) {
            addCriterion("scd_last_run_time <", value, "scdLastRunTime");
            return (Criteria) this;
        }

        public Criteria andScdLastRunTimeLessThanOrEqualTo(Date value) {
            addCriterion("scd_last_run_time <=", value, "scdLastRunTime");
            return (Criteria) this;
        }

        public Criteria andScdLastRunTimeIn(List<Date> values) {
            addCriterion("scd_last_run_time in", values, "scdLastRunTime");
            return (Criteria) this;
        }

        public Criteria andScdLastRunTimeNotIn(List<Date> values) {
            addCriterion("scd_last_run_time not in", values, "scdLastRunTime");
            return (Criteria) this;
        }

        public Criteria andScdLastRunTimeBetween(Date value1, Date value2) {
            addCriterion("scd_last_run_time between", value1, value2, "scdLastRunTime");
            return (Criteria) this;
        }

        public Criteria andScdLastRunTimeNotBetween(Date value1, Date value2) {
            addCriterion("scd_last_run_time not between", value1, value2, "scdLastRunTime");
            return (Criteria) this;
        }

        public Criteria andScdNextRunTimeIsNull() {
            addCriterion("scd_next_run_time is null");
            return (Criteria) this;
        }

        public Criteria andScdNextRunTimeIsNotNull() {
            addCriterion("scd_next_run_time is not null");
            return (Criteria) this;
        }

        public Criteria andScdNextRunTimeEqualTo(Date value) {
            addCriterion("scd_next_run_time =", value, "scdNextRunTime");
            return (Criteria) this;
        }

        public Criteria andScdNextRunTimeNotEqualTo(Date value) {
            addCriterion("scd_next_run_time <>", value, "scdNextRunTime");
            return (Criteria) this;
        }

        public Criteria andScdNextRunTimeGreaterThan(Date value) {
            addCriterion("scd_next_run_time >", value, "scdNextRunTime");
            return (Criteria) this;
        }

        public Criteria andScdNextRunTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("scd_next_run_time >=", value, "scdNextRunTime");
            return (Criteria) this;
        }

        public Criteria andScdNextRunTimeLessThan(Date value) {
            addCriterion("scd_next_run_time <", value, "scdNextRunTime");
            return (Criteria) this;
        }

        public Criteria andScdNextRunTimeLessThanOrEqualTo(Date value) {
            addCriterion("scd_next_run_time <=", value, "scdNextRunTime");
            return (Criteria) this;
        }

        public Criteria andScdNextRunTimeIn(List<Date> values) {
            addCriterion("scd_next_run_time in", values, "scdNextRunTime");
            return (Criteria) this;
        }

        public Criteria andScdNextRunTimeNotIn(List<Date> values) {
            addCriterion("scd_next_run_time not in", values, "scdNextRunTime");
            return (Criteria) this;
        }

        public Criteria andScdNextRunTimeBetween(Date value1, Date value2) {
            addCriterion("scd_next_run_time between", value1, value2, "scdNextRunTime");
            return (Criteria) this;
        }

        public Criteria andScdNextRunTimeNotBetween(Date value1, Date value2) {
            addCriterion("scd_next_run_time not between", value1, value2, "scdNextRunTime");
            return (Criteria) this;
        }

        public Criteria andSchedulejobcolIsNull() {
            addCriterion("schedulejobcol is null");
            return (Criteria) this;
        }

        public Criteria andSchedulejobcolIsNotNull() {
            addCriterion("schedulejobcol is not null");
            return (Criteria) this;
        }

        public Criteria andSchedulejobcolEqualTo(String value) {
            addCriterion("schedulejobcol =", value, "schedulejobcol");
            return (Criteria) this;
        }

        public Criteria andSchedulejobcolNotEqualTo(String value) {
            addCriterion("schedulejobcol <>", value, "schedulejobcol");
            return (Criteria) this;
        }

        public Criteria andSchedulejobcolGreaterThan(String value) {
            addCriterion("schedulejobcol >", value, "schedulejobcol");
            return (Criteria) this;
        }

        public Criteria andSchedulejobcolGreaterThanOrEqualTo(String value) {
            addCriterion("schedulejobcol >=", value, "schedulejobcol");
            return (Criteria) this;
        }

        public Criteria andSchedulejobcolLessThan(String value) {
            addCriterion("schedulejobcol <", value, "schedulejobcol");
            return (Criteria) this;
        }

        public Criteria andSchedulejobcolLessThanOrEqualTo(String value) {
            addCriterion("schedulejobcol <=", value, "schedulejobcol");
            return (Criteria) this;
        }

        public Criteria andSchedulejobcolLike(String value) {
            addCriterion("schedulejobcol like", value, "schedulejobcol");
            return (Criteria) this;
        }

        public Criteria andSchedulejobcolNotLike(String value) {
            addCriterion("schedulejobcol not like", value, "schedulejobcol");
            return (Criteria) this;
        }

        public Criteria andSchedulejobcolIn(List<String> values) {
            addCriterion("schedulejobcol in", values, "schedulejobcol");
            return (Criteria) this;
        }

        public Criteria andSchedulejobcolNotIn(List<String> values) {
            addCriterion("schedulejobcol not in", values, "schedulejobcol");
            return (Criteria) this;
        }

        public Criteria andSchedulejobcolBetween(String value1, String value2) {
            addCriterion("schedulejobcol between", value1, value2, "schedulejobcol");
            return (Criteria) this;
        }

        public Criteria andSchedulejobcolNotBetween(String value1, String value2) {
            addCriterion("schedulejobcol not between", value1, value2, "schedulejobcol");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}