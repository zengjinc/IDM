package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class ResourceTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResourceTypeExample() {
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

        public Criteria andResTypeUuidIsNull() {
            addCriterion("res_type_uuid is null");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidIsNotNull() {
            addCriterion("res_type_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidEqualTo(String value) {
            addCriterion("res_type_uuid =", value, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidNotEqualTo(String value) {
            addCriterion("res_type_uuid <>", value, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidGreaterThan(String value) {
            addCriterion("res_type_uuid >", value, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidGreaterThanOrEqualTo(String value) {
            addCriterion("res_type_uuid >=", value, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidLessThan(String value) {
            addCriterion("res_type_uuid <", value, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidLessThanOrEqualTo(String value) {
            addCriterion("res_type_uuid <=", value, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidLike(String value) {
            addCriterion("res_type_uuid like", value, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidNotLike(String value) {
            addCriterion("res_type_uuid not like", value, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidIn(List<String> values) {
            addCriterion("res_type_uuid in", values, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidNotIn(List<String> values) {
            addCriterion("res_type_uuid not in", values, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidBetween(String value1, String value2) {
            addCriterion("res_type_uuid between", value1, value2, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeUuidNotBetween(String value1, String value2) {
            addCriterion("res_type_uuid not between", value1, value2, "resTypeUuid");
            return (Criteria) this;
        }

        public Criteria andResTypeNameIsNull() {
            addCriterion("res_type_name is null");
            return (Criteria) this;
        }

        public Criteria andResTypeNameIsNotNull() {
            addCriterion("res_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andResTypeNameEqualTo(String value) {
            addCriterion("res_type_name =", value, "resTypeName");
            return (Criteria) this;
        }

        public Criteria andResTypeNameNotEqualTo(String value) {
            addCriterion("res_type_name <>", value, "resTypeName");
            return (Criteria) this;
        }

        public Criteria andResTypeNameGreaterThan(String value) {
            addCriterion("res_type_name >", value, "resTypeName");
            return (Criteria) this;
        }

        public Criteria andResTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("res_type_name >=", value, "resTypeName");
            return (Criteria) this;
        }

        public Criteria andResTypeNameLessThan(String value) {
            addCriterion("res_type_name <", value, "resTypeName");
            return (Criteria) this;
        }

        public Criteria andResTypeNameLessThanOrEqualTo(String value) {
            addCriterion("res_type_name <=", value, "resTypeName");
            return (Criteria) this;
        }

        public Criteria andResTypeNameLike(String value) {
            addCriterion("res_type_name like", value, "resTypeName");
            return (Criteria) this;
        }

        public Criteria andResTypeNameNotLike(String value) {
            addCriterion("res_type_name not like", value, "resTypeName");
            return (Criteria) this;
        }

        public Criteria andResTypeNameIn(List<String> values) {
            addCriterion("res_type_name in", values, "resTypeName");
            return (Criteria) this;
        }

        public Criteria andResTypeNameNotIn(List<String> values) {
            addCriterion("res_type_name not in", values, "resTypeName");
            return (Criteria) this;
        }

        public Criteria andResTypeNameBetween(String value1, String value2) {
            addCriterion("res_type_name between", value1, value2, "resTypeName");
            return (Criteria) this;
        }

        public Criteria andResTypeNameNotBetween(String value1, String value2) {
            addCriterion("res_type_name not between", value1, value2, "resTypeName");
            return (Criteria) this;
        }

        public Criteria andResTypeHandlerIsNull() {
            addCriterion("res_type_handler is null");
            return (Criteria) this;
        }

        public Criteria andResTypeHandlerIsNotNull() {
            addCriterion("res_type_handler is not null");
            return (Criteria) this;
        }

        public Criteria andResTypeHandlerEqualTo(String value) {
            addCriterion("res_type_handler =", value, "resTypeHandler");
            return (Criteria) this;
        }

        public Criteria andResTypeHandlerNotEqualTo(String value) {
            addCriterion("res_type_handler <>", value, "resTypeHandler");
            return (Criteria) this;
        }

        public Criteria andResTypeHandlerGreaterThan(String value) {
            addCriterion("res_type_handler >", value, "resTypeHandler");
            return (Criteria) this;
        }

        public Criteria andResTypeHandlerGreaterThanOrEqualTo(String value) {
            addCriterion("res_type_handler >=", value, "resTypeHandler");
            return (Criteria) this;
        }

        public Criteria andResTypeHandlerLessThan(String value) {
            addCriterion("res_type_handler <", value, "resTypeHandler");
            return (Criteria) this;
        }

        public Criteria andResTypeHandlerLessThanOrEqualTo(String value) {
            addCriterion("res_type_handler <=", value, "resTypeHandler");
            return (Criteria) this;
        }

        public Criteria andResTypeHandlerLike(String value) {
            addCriterion("res_type_handler like", value, "resTypeHandler");
            return (Criteria) this;
        }

        public Criteria andResTypeHandlerNotLike(String value) {
            addCriterion("res_type_handler not like", value, "resTypeHandler");
            return (Criteria) this;
        }

        public Criteria andResTypeHandlerIn(List<String> values) {
            addCriterion("res_type_handler in", values, "resTypeHandler");
            return (Criteria) this;
        }

        public Criteria andResTypeHandlerNotIn(List<String> values) {
            addCriterion("res_type_handler not in", values, "resTypeHandler");
            return (Criteria) this;
        }

        public Criteria andResTypeHandlerBetween(String value1, String value2) {
            addCriterion("res_type_handler between", value1, value2, "resTypeHandler");
            return (Criteria) this;
        }

        public Criteria andResTypeHandlerNotBetween(String value1, String value2) {
            addCriterion("res_type_handler not between", value1, value2, "resTypeHandler");
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