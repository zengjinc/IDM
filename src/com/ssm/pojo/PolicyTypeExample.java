package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class PolicyTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PolicyTypeExample() {
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

        public Criteria andPolTypeUuidIsNull() {
            addCriterion("pol_type_uuid is null");
            return (Criteria) this;
        }

        public Criteria andPolTypeUuidIsNotNull() {
            addCriterion("pol_type_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andPolTypeUuidEqualTo(String value) {
            addCriterion("pol_type_uuid =", value, "polTypeUuid");
            return (Criteria) this;
        }

        public Criteria andPolTypeUuidNotEqualTo(String value) {
            addCriterion("pol_type_uuid <>", value, "polTypeUuid");
            return (Criteria) this;
        }

        public Criteria andPolTypeUuidGreaterThan(String value) {
            addCriterion("pol_type_uuid >", value, "polTypeUuid");
            return (Criteria) this;
        }

        public Criteria andPolTypeUuidGreaterThanOrEqualTo(String value) {
            addCriterion("pol_type_uuid >=", value, "polTypeUuid");
            return (Criteria) this;
        }

        public Criteria andPolTypeUuidLessThan(String value) {
            addCriterion("pol_type_uuid <", value, "polTypeUuid");
            return (Criteria) this;
        }

        public Criteria andPolTypeUuidLessThanOrEqualTo(String value) {
            addCriterion("pol_type_uuid <=", value, "polTypeUuid");
            return (Criteria) this;
        }

        public Criteria andPolTypeUuidLike(String value) {
            addCriterion("pol_type_uuid like", value, "polTypeUuid");
            return (Criteria) this;
        }

        public Criteria andPolTypeUuidNotLike(String value) {
            addCriterion("pol_type_uuid not like", value, "polTypeUuid");
            return (Criteria) this;
        }

        public Criteria andPolTypeUuidIn(List<String> values) {
            addCriterion("pol_type_uuid in", values, "polTypeUuid");
            return (Criteria) this;
        }

        public Criteria andPolTypeUuidNotIn(List<String> values) {
            addCriterion("pol_type_uuid not in", values, "polTypeUuid");
            return (Criteria) this;
        }

        public Criteria andPolTypeUuidBetween(String value1, String value2) {
            addCriterion("pol_type_uuid between", value1, value2, "polTypeUuid");
            return (Criteria) this;
        }

        public Criteria andPolTypeUuidNotBetween(String value1, String value2) {
            addCriterion("pol_type_uuid not between", value1, value2, "polTypeUuid");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameIsNull() {
            addCriterion("pol_type_name is null");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameIsNotNull() {
            addCriterion("pol_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameEqualTo(String value) {
            addCriterion("pol_type_name =", value, "polTypeName");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameNotEqualTo(String value) {
            addCriterion("pol_type_name <>", value, "polTypeName");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameGreaterThan(String value) {
            addCriterion("pol_type_name >", value, "polTypeName");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("pol_type_name >=", value, "polTypeName");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameLessThan(String value) {
            addCriterion("pol_type_name <", value, "polTypeName");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameLessThanOrEqualTo(String value) {
            addCriterion("pol_type_name <=", value, "polTypeName");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameLike(String value) {
            addCriterion("pol_type_name like", value, "polTypeName");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameNotLike(String value) {
            addCriterion("pol_type_name not like", value, "polTypeName");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameIn(List<String> values) {
            addCriterion("pol_type_name in", values, "polTypeName");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameNotIn(List<String> values) {
            addCriterion("pol_type_name not in", values, "polTypeName");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameBetween(String value1, String value2) {
            addCriterion("pol_type_name between", value1, value2, "polTypeName");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameNotBetween(String value1, String value2) {
            addCriterion("pol_type_name not between", value1, value2, "polTypeName");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameDescIsNull() {
            addCriterion("pol_type_name_desc is null");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameDescIsNotNull() {
            addCriterion("pol_type_name_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameDescEqualTo(String value) {
            addCriterion("pol_type_name_desc =", value, "polTypeNameDesc");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameDescNotEqualTo(String value) {
            addCriterion("pol_type_name_desc <>", value, "polTypeNameDesc");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameDescGreaterThan(String value) {
            addCriterion("pol_type_name_desc >", value, "polTypeNameDesc");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameDescGreaterThanOrEqualTo(String value) {
            addCriterion("pol_type_name_desc >=", value, "polTypeNameDesc");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameDescLessThan(String value) {
            addCriterion("pol_type_name_desc <", value, "polTypeNameDesc");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameDescLessThanOrEqualTo(String value) {
            addCriterion("pol_type_name_desc <=", value, "polTypeNameDesc");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameDescLike(String value) {
            addCriterion("pol_type_name_desc like", value, "polTypeNameDesc");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameDescNotLike(String value) {
            addCriterion("pol_type_name_desc not like", value, "polTypeNameDesc");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameDescIn(List<String> values) {
            addCriterion("pol_type_name_desc in", values, "polTypeNameDesc");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameDescNotIn(List<String> values) {
            addCriterion("pol_type_name_desc not in", values, "polTypeNameDesc");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameDescBetween(String value1, String value2) {
            addCriterion("pol_type_name_desc between", value1, value2, "polTypeNameDesc");
            return (Criteria) this;
        }

        public Criteria andPolTypeNameDescNotBetween(String value1, String value2) {
            addCriterion("pol_type_name_desc not between", value1, value2, "polTypeNameDesc");
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