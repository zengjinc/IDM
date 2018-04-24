package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class PolicyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PolicyExample() {
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

        public Criteria andPolUuidIsNull() {
            addCriterion("pol_uuid is null");
            return (Criteria) this;
        }

        public Criteria andPolUuidIsNotNull() {
            addCriterion("pol_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andPolUuidEqualTo(String value) {
            addCriterion("pol_uuid =", value, "polUuid");
            return (Criteria) this;
        }

        public Criteria andPolUuidNotEqualTo(String value) {
            addCriterion("pol_uuid <>", value, "polUuid");
            return (Criteria) this;
        }

        public Criteria andPolUuidGreaterThan(String value) {
            addCriterion("pol_uuid >", value, "polUuid");
            return (Criteria) this;
        }

        public Criteria andPolUuidGreaterThanOrEqualTo(String value) {
            addCriterion("pol_uuid >=", value, "polUuid");
            return (Criteria) this;
        }

        public Criteria andPolUuidLessThan(String value) {
            addCriterion("pol_uuid <", value, "polUuid");
            return (Criteria) this;
        }

        public Criteria andPolUuidLessThanOrEqualTo(String value) {
            addCriterion("pol_uuid <=", value, "polUuid");
            return (Criteria) this;
        }

        public Criteria andPolUuidLike(String value) {
            addCriterion("pol_uuid like", value, "polUuid");
            return (Criteria) this;
        }

        public Criteria andPolUuidNotLike(String value) {
            addCriterion("pol_uuid not like", value, "polUuid");
            return (Criteria) this;
        }

        public Criteria andPolUuidIn(List<String> values) {
            addCriterion("pol_uuid in", values, "polUuid");
            return (Criteria) this;
        }

        public Criteria andPolUuidNotIn(List<String> values) {
            addCriterion("pol_uuid not in", values, "polUuid");
            return (Criteria) this;
        }

        public Criteria andPolUuidBetween(String value1, String value2) {
            addCriterion("pol_uuid between", value1, value2, "polUuid");
            return (Criteria) this;
        }

        public Criteria andPolUuidNotBetween(String value1, String value2) {
            addCriterion("pol_uuid not between", value1, value2, "polUuid");
            return (Criteria) this;
        }

        public Criteria andPolIdIsNull() {
            addCriterion("pol_id is null");
            return (Criteria) this;
        }

        public Criteria andPolIdIsNotNull() {
            addCriterion("pol_id is not null");
            return (Criteria) this;
        }

        public Criteria andPolIdEqualTo(String value) {
            addCriterion("pol_id =", value, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdNotEqualTo(String value) {
            addCriterion("pol_id <>", value, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdGreaterThan(String value) {
            addCriterion("pol_id >", value, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdGreaterThanOrEqualTo(String value) {
            addCriterion("pol_id >=", value, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdLessThan(String value) {
            addCriterion("pol_id <", value, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdLessThanOrEqualTo(String value) {
            addCriterion("pol_id <=", value, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdLike(String value) {
            addCriterion("pol_id like", value, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdNotLike(String value) {
            addCriterion("pol_id not like", value, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdIn(List<String> values) {
            addCriterion("pol_id in", values, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdNotIn(List<String> values) {
            addCriterion("pol_id not in", values, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdBetween(String value1, String value2) {
            addCriterion("pol_id between", value1, value2, "polId");
            return (Criteria) this;
        }

        public Criteria andPolIdNotBetween(String value1, String value2) {
            addCriterion("pol_id not between", value1, value2, "polId");
            return (Criteria) this;
        }

        public Criteria andPolNameIsNull() {
            addCriterion("pol_name is null");
            return (Criteria) this;
        }

        public Criteria andPolNameIsNotNull() {
            addCriterion("pol_name is not null");
            return (Criteria) this;
        }

        public Criteria andPolNameEqualTo(String value) {
            addCriterion("pol_name =", value, "polName");
            return (Criteria) this;
        }

        public Criteria andPolNameNotEqualTo(String value) {
            addCriterion("pol_name <>", value, "polName");
            return (Criteria) this;
        }

        public Criteria andPolNameGreaterThan(String value) {
            addCriterion("pol_name >", value, "polName");
            return (Criteria) this;
        }

        public Criteria andPolNameGreaterThanOrEqualTo(String value) {
            addCriterion("pol_name >=", value, "polName");
            return (Criteria) this;
        }

        public Criteria andPolNameLessThan(String value) {
            addCriterion("pol_name <", value, "polName");
            return (Criteria) this;
        }

        public Criteria andPolNameLessThanOrEqualTo(String value) {
            addCriterion("pol_name <=", value, "polName");
            return (Criteria) this;
        }

        public Criteria andPolNameLike(String value) {
            addCriterion("pol_name like", value, "polName");
            return (Criteria) this;
        }

        public Criteria andPolNameNotLike(String value) {
            addCriterion("pol_name not like", value, "polName");
            return (Criteria) this;
        }

        public Criteria andPolNameIn(List<String> values) {
            addCriterion("pol_name in", values, "polName");
            return (Criteria) this;
        }

        public Criteria andPolNameNotIn(List<String> values) {
            addCriterion("pol_name not in", values, "polName");
            return (Criteria) this;
        }

        public Criteria andPolNameBetween(String value1, String value2) {
            addCriterion("pol_name between", value1, value2, "polName");
            return (Criteria) this;
        }

        public Criteria andPolNameNotBetween(String value1, String value2) {
            addCriterion("pol_name not between", value1, value2, "polName");
            return (Criteria) this;
        }

        public Criteria andPolDescIsNull() {
            addCriterion("pol_desc is null");
            return (Criteria) this;
        }

        public Criteria andPolDescIsNotNull() {
            addCriterion("pol_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPolDescEqualTo(String value) {
            addCriterion("pol_desc =", value, "polDesc");
            return (Criteria) this;
        }

        public Criteria andPolDescNotEqualTo(String value) {
            addCriterion("pol_desc <>", value, "polDesc");
            return (Criteria) this;
        }

        public Criteria andPolDescGreaterThan(String value) {
            addCriterion("pol_desc >", value, "polDesc");
            return (Criteria) this;
        }

        public Criteria andPolDescGreaterThanOrEqualTo(String value) {
            addCriterion("pol_desc >=", value, "polDesc");
            return (Criteria) this;
        }

        public Criteria andPolDescLessThan(String value) {
            addCriterion("pol_desc <", value, "polDesc");
            return (Criteria) this;
        }

        public Criteria andPolDescLessThanOrEqualTo(String value) {
            addCriterion("pol_desc <=", value, "polDesc");
            return (Criteria) this;
        }

        public Criteria andPolDescLike(String value) {
            addCriterion("pol_desc like", value, "polDesc");
            return (Criteria) this;
        }

        public Criteria andPolDescNotLike(String value) {
            addCriterion("pol_desc not like", value, "polDesc");
            return (Criteria) this;
        }

        public Criteria andPolDescIn(List<String> values) {
            addCriterion("pol_desc in", values, "polDesc");
            return (Criteria) this;
        }

        public Criteria andPolDescNotIn(List<String> values) {
            addCriterion("pol_desc not in", values, "polDesc");
            return (Criteria) this;
        }

        public Criteria andPolDescBetween(String value1, String value2) {
            addCriterion("pol_desc between", value1, value2, "polDesc");
            return (Criteria) this;
        }

        public Criteria andPolDescNotBetween(String value1, String value2) {
            addCriterion("pol_desc not between", value1, value2, "polDesc");
            return (Criteria) this;
        }

        public Criteria andPolTypeIsNull() {
            addCriterion("pol_type is null");
            return (Criteria) this;
        }

        public Criteria andPolTypeIsNotNull() {
            addCriterion("pol_type is not null");
            return (Criteria) this;
        }

        public Criteria andPolTypeEqualTo(String value) {
            addCriterion("pol_type =", value, "polType");
            return (Criteria) this;
        }

        public Criteria andPolTypeNotEqualTo(String value) {
            addCriterion("pol_type <>", value, "polType");
            return (Criteria) this;
        }

        public Criteria andPolTypeGreaterThan(String value) {
            addCriterion("pol_type >", value, "polType");
            return (Criteria) this;
        }

        public Criteria andPolTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pol_type >=", value, "polType");
            return (Criteria) this;
        }

        public Criteria andPolTypeLessThan(String value) {
            addCriterion("pol_type <", value, "polType");
            return (Criteria) this;
        }

        public Criteria andPolTypeLessThanOrEqualTo(String value) {
            addCriterion("pol_type <=", value, "polType");
            return (Criteria) this;
        }

        public Criteria andPolTypeLike(String value) {
            addCriterion("pol_type like", value, "polType");
            return (Criteria) this;
        }

        public Criteria andPolTypeNotLike(String value) {
            addCriterion("pol_type not like", value, "polType");
            return (Criteria) this;
        }

        public Criteria andPolTypeIn(List<String> values) {
            addCriterion("pol_type in", values, "polType");
            return (Criteria) this;
        }

        public Criteria andPolTypeNotIn(List<String> values) {
            addCriterion("pol_type not in", values, "polType");
            return (Criteria) this;
        }

        public Criteria andPolTypeBetween(String value1, String value2) {
            addCriterion("pol_type between", value1, value2, "polType");
            return (Criteria) this;
        }

        public Criteria andPolTypeNotBetween(String value1, String value2) {
            addCriterion("pol_type not between", value1, value2, "polType");
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