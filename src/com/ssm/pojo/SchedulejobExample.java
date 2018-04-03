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

        public Criteria andScdIdIsNull() {
            addCriterion("scd_id is null");
            return (Criteria) this;
        }

        public Criteria andScdIdIsNotNull() {
            addCriterion("scd_id is not null");
            return (Criteria) this;
        }

        public Criteria andScdIdEqualTo(String value) {
            addCriterion("scd_id =", value, "scdId");
            return (Criteria) this;
        }

        public Criteria andScdIdNotEqualTo(String value) {
            addCriterion("scd_id <>", value, "scdId");
            return (Criteria) this;
        }

        public Criteria andScdIdGreaterThan(String value) {
            addCriterion("scd_id >", value, "scdId");
            return (Criteria) this;
        }

        public Criteria andScdIdGreaterThanOrEqualTo(String value) {
            addCriterion("scd_id >=", value, "scdId");
            return (Criteria) this;
        }

        public Criteria andScdIdLessThan(String value) {
            addCriterion("scd_id <", value, "scdId");
            return (Criteria) this;
        }

        public Criteria andScdIdLessThanOrEqualTo(String value) {
            addCriterion("scd_id <=", value, "scdId");
            return (Criteria) this;
        }

        public Criteria andScdIdLike(String value) {
            addCriterion("scd_id like", value, "scdId");
            return (Criteria) this;
        }

        public Criteria andScdIdNotLike(String value) {
            addCriterion("scd_id not like", value, "scdId");
            return (Criteria) this;
        }

        public Criteria andScdIdIn(List<String> values) {
            addCriterion("scd_id in", values, "scdId");
            return (Criteria) this;
        }

        public Criteria andScdIdNotIn(List<String> values) {
            addCriterion("scd_id not in", values, "scdId");
            return (Criteria) this;
        }

        public Criteria andScdIdBetween(String value1, String value2) {
            addCriterion("scd_id between", value1, value2, "scdId");
            return (Criteria) this;
        }

        public Criteria andScdIdNotBetween(String value1, String value2) {
            addCriterion("scd_id not between", value1, value2, "scdId");
            return (Criteria) this;
        }

        public Criteria andScdNameIsNull() {
            addCriterion("scd_name is null");
            return (Criteria) this;
        }

        public Criteria andScdNameIsNotNull() {
            addCriterion("scd_name is not null");
            return (Criteria) this;
        }

        public Criteria andScdNameEqualTo(String value) {
            addCriterion("scd_name =", value, "scdName");
            return (Criteria) this;
        }

        public Criteria andScdNameNotEqualTo(String value) {
            addCriterion("scd_name <>", value, "scdName");
            return (Criteria) this;
        }

        public Criteria andScdNameGreaterThan(String value) {
            addCriterion("scd_name >", value, "scdName");
            return (Criteria) this;
        }

        public Criteria andScdNameGreaterThanOrEqualTo(String value) {
            addCriterion("scd_name >=", value, "scdName");
            return (Criteria) this;
        }

        public Criteria andScdNameLessThan(String value) {
            addCriterion("scd_name <", value, "scdName");
            return (Criteria) this;
        }

        public Criteria andScdNameLessThanOrEqualTo(String value) {
            addCriterion("scd_name <=", value, "scdName");
            return (Criteria) this;
        }

        public Criteria andScdNameLike(String value) {
            addCriterion("scd_name like", value, "scdName");
            return (Criteria) this;
        }

        public Criteria andScdNameNotLike(String value) {
            addCriterion("scd_name not like", value, "scdName");
            return (Criteria) this;
        }

        public Criteria andScdNameIn(List<String> values) {
            addCriterion("scd_name in", values, "scdName");
            return (Criteria) this;
        }

        public Criteria andScdNameNotIn(List<String> values) {
            addCriterion("scd_name not in", values, "scdName");
            return (Criteria) this;
        }

        public Criteria andScdNameBetween(String value1, String value2) {
            addCriterion("scd_name between", value1, value2, "scdName");
            return (Criteria) this;
        }

        public Criteria andScdNameNotBetween(String value1, String value2) {
            addCriterion("scd_name not between", value1, value2, "scdName");
            return (Criteria) this;
        }

        public Criteria andScdJobGroupIsNull() {
            addCriterion("scd_job_group is null");
            return (Criteria) this;
        }

        public Criteria andScdJobGroupIsNotNull() {
            addCriterion("scd_job_group is not null");
            return (Criteria) this;
        }

        public Criteria andScdJobGroupEqualTo(String value) {
            addCriterion("scd_job_group =", value, "scdJobGroup");
            return (Criteria) this;
        }

        public Criteria andScdJobGroupNotEqualTo(String value) {
            addCriterion("scd_job_group <>", value, "scdJobGroup");
            return (Criteria) this;
        }

        public Criteria andScdJobGroupGreaterThan(String value) {
            addCriterion("scd_job_group >", value, "scdJobGroup");
            return (Criteria) this;
        }

        public Criteria andScdJobGroupGreaterThanOrEqualTo(String value) {
            addCriterion("scd_job_group >=", value, "scdJobGroup");
            return (Criteria) this;
        }

        public Criteria andScdJobGroupLessThan(String value) {
            addCriterion("scd_job_group <", value, "scdJobGroup");
            return (Criteria) this;
        }

        public Criteria andScdJobGroupLessThanOrEqualTo(String value) {
            addCriterion("scd_job_group <=", value, "scdJobGroup");
            return (Criteria) this;
        }

        public Criteria andScdJobGroupLike(String value) {
            addCriterion("scd_job_group like", value, "scdJobGroup");
            return (Criteria) this;
        }

        public Criteria andScdJobGroupNotLike(String value) {
            addCriterion("scd_job_group not like", value, "scdJobGroup");
            return (Criteria) this;
        }

        public Criteria andScdJobGroupIn(List<String> values) {
            addCriterion("scd_job_group in", values, "scdJobGroup");
            return (Criteria) this;
        }

        public Criteria andScdJobGroupNotIn(List<String> values) {
            addCriterion("scd_job_group not in", values, "scdJobGroup");
            return (Criteria) this;
        }

        public Criteria andScdJobGroupBetween(String value1, String value2) {
            addCriterion("scd_job_group between", value1, value2, "scdJobGroup");
            return (Criteria) this;
        }

        public Criteria andScdJobGroupNotBetween(String value1, String value2) {
            addCriterion("scd_job_group not between", value1, value2, "scdJobGroup");
            return (Criteria) this;
        }

        public Criteria andScdCronIsNull() {
            addCriterion("scd_cron is null");
            return (Criteria) this;
        }

        public Criteria andScdCronIsNotNull() {
            addCriterion("scd_cron is not null");
            return (Criteria) this;
        }

        public Criteria andScdCronEqualTo(String value) {
            addCriterion("scd_cron =", value, "scdCron");
            return (Criteria) this;
        }

        public Criteria andScdCronNotEqualTo(String value) {
            addCriterion("scd_cron <>", value, "scdCron");
            return (Criteria) this;
        }

        public Criteria andScdCronGreaterThan(String value) {
            addCriterion("scd_cron >", value, "scdCron");
            return (Criteria) this;
        }

        public Criteria andScdCronGreaterThanOrEqualTo(String value) {
            addCriterion("scd_cron >=", value, "scdCron");
            return (Criteria) this;
        }

        public Criteria andScdCronLessThan(String value) {
            addCriterion("scd_cron <", value, "scdCron");
            return (Criteria) this;
        }

        public Criteria andScdCronLessThanOrEqualTo(String value) {
            addCriterion("scd_cron <=", value, "scdCron");
            return (Criteria) this;
        }

        public Criteria andScdCronLike(String value) {
            addCriterion("scd_cron like", value, "scdCron");
            return (Criteria) this;
        }

        public Criteria andScdCronNotLike(String value) {
            addCriterion("scd_cron not like", value, "scdCron");
            return (Criteria) this;
        }

        public Criteria andScdCronIn(List<String> values) {
            addCriterion("scd_cron in", values, "scdCron");
            return (Criteria) this;
        }

        public Criteria andScdCronNotIn(List<String> values) {
            addCriterion("scd_cron not in", values, "scdCron");
            return (Criteria) this;
        }

        public Criteria andScdCronBetween(String value1, String value2) {
            addCriterion("scd_cron between", value1, value2, "scdCron");
            return (Criteria) this;
        }

        public Criteria andScdCronNotBetween(String value1, String value2) {
            addCriterion("scd_cron not between", value1, value2, "scdCron");
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

        public Criteria andScdJobTypeIsNull() {
            addCriterion("scd_job_type is null");
            return (Criteria) this;
        }

        public Criteria andScdJobTypeIsNotNull() {
            addCriterion("scd_job_type is not null");
            return (Criteria) this;
        }

        public Criteria andScdJobTypeEqualTo(String value) {
            addCriterion("scd_job_type =", value, "scdJobType");
            return (Criteria) this;
        }

        public Criteria andScdJobTypeNotEqualTo(String value) {
            addCriterion("scd_job_type <>", value, "scdJobType");
            return (Criteria) this;
        }

        public Criteria andScdJobTypeGreaterThan(String value) {
            addCriterion("scd_job_type >", value, "scdJobType");
            return (Criteria) this;
        }

        public Criteria andScdJobTypeGreaterThanOrEqualTo(String value) {
            addCriterion("scd_job_type >=", value, "scdJobType");
            return (Criteria) this;
        }

        public Criteria andScdJobTypeLessThan(String value) {
            addCriterion("scd_job_type <", value, "scdJobType");
            return (Criteria) this;
        }

        public Criteria andScdJobTypeLessThanOrEqualTo(String value) {
            addCriterion("scd_job_type <=", value, "scdJobType");
            return (Criteria) this;
        }

        public Criteria andScdJobTypeLike(String value) {
            addCriterion("scd_job_type like", value, "scdJobType");
            return (Criteria) this;
        }

        public Criteria andScdJobTypeNotLike(String value) {
            addCriterion("scd_job_type not like", value, "scdJobType");
            return (Criteria) this;
        }

        public Criteria andScdJobTypeIn(List<String> values) {
            addCriterion("scd_job_type in", values, "scdJobType");
            return (Criteria) this;
        }

        public Criteria andScdJobTypeNotIn(List<String> values) {
            addCriterion("scd_job_type not in", values, "scdJobType");
            return (Criteria) this;
        }

        public Criteria andScdJobTypeBetween(String value1, String value2) {
            addCriterion("scd_job_type between", value1, value2, "scdJobType");
            return (Criteria) this;
        }

        public Criteria andScdJobTypeNotBetween(String value1, String value2) {
            addCriterion("scd_job_type not between", value1, value2, "scdJobType");
            return (Criteria) this;
        }

        public Criteria andScdDescIsNull() {
            addCriterion("scd_desc is null");
            return (Criteria) this;
        }

        public Criteria andScdDescIsNotNull() {
            addCriterion("scd_desc is not null");
            return (Criteria) this;
        }

        public Criteria andScdDescEqualTo(String value) {
            addCriterion("scd_desc =", value, "scdDesc");
            return (Criteria) this;
        }

        public Criteria andScdDescNotEqualTo(String value) {
            addCriterion("scd_desc <>", value, "scdDesc");
            return (Criteria) this;
        }

        public Criteria andScdDescGreaterThan(String value) {
            addCriterion("scd_desc >", value, "scdDesc");
            return (Criteria) this;
        }

        public Criteria andScdDescGreaterThanOrEqualTo(String value) {
            addCriterion("scd_desc >=", value, "scdDesc");
            return (Criteria) this;
        }

        public Criteria andScdDescLessThan(String value) {
            addCriterion("scd_desc <", value, "scdDesc");
            return (Criteria) this;
        }

        public Criteria andScdDescLessThanOrEqualTo(String value) {
            addCriterion("scd_desc <=", value, "scdDesc");
            return (Criteria) this;
        }

        public Criteria andScdDescLike(String value) {
            addCriterion("scd_desc like", value, "scdDesc");
            return (Criteria) this;
        }

        public Criteria andScdDescNotLike(String value) {
            addCriterion("scd_desc not like", value, "scdDesc");
            return (Criteria) this;
        }

        public Criteria andScdDescIn(List<String> values) {
            addCriterion("scd_desc in", values, "scdDesc");
            return (Criteria) this;
        }

        public Criteria andScdDescNotIn(List<String> values) {
            addCriterion("scd_desc not in", values, "scdDesc");
            return (Criteria) this;
        }

        public Criteria andScdDescBetween(String value1, String value2) {
            addCriterion("scd_desc between", value1, value2, "scdDesc");
            return (Criteria) this;
        }

        public Criteria andScdDescNotBetween(String value1, String value2) {
            addCriterion("scd_desc not between", value1, value2, "scdDesc");
            return (Criteria) this;
        }

        public Criteria andScdStatusIsNull() {
            addCriterion("scd_status is null");
            return (Criteria) this;
        }

        public Criteria andScdStatusIsNotNull() {
            addCriterion("scd_status is not null");
            return (Criteria) this;
        }

        public Criteria andScdStatusEqualTo(Integer value) {
            addCriterion("scd_status =", value, "scdStatus");
            return (Criteria) this;
        }

        public Criteria andScdStatusNotEqualTo(Integer value) {
            addCriterion("scd_status <>", value, "scdStatus");
            return (Criteria) this;
        }

        public Criteria andScdStatusGreaterThan(Integer value) {
            addCriterion("scd_status >", value, "scdStatus");
            return (Criteria) this;
        }

        public Criteria andScdStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("scd_status >=", value, "scdStatus");
            return (Criteria) this;
        }

        public Criteria andScdStatusLessThan(Integer value) {
            addCriterion("scd_status <", value, "scdStatus");
            return (Criteria) this;
        }

        public Criteria andScdStatusLessThanOrEqualTo(Integer value) {
            addCriterion("scd_status <=", value, "scdStatus");
            return (Criteria) this;
        }

        public Criteria andScdStatusIn(List<Integer> values) {
            addCriterion("scd_status in", values, "scdStatus");
            return (Criteria) this;
        }

        public Criteria andScdStatusNotIn(List<Integer> values) {
            addCriterion("scd_status not in", values, "scdStatus");
            return (Criteria) this;
        }

        public Criteria andScdStatusBetween(Integer value1, Integer value2) {
            addCriterion("scd_status between", value1, value2, "scdStatus");
            return (Criteria) this;
        }

        public Criteria andScdStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("scd_status not between", value1, value2, "scdStatus");
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