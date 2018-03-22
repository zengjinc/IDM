package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class RelUserOuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RelUserOuExample() {
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

        public Criteria andRelUserOuUserUuidIsNull() {
            addCriterion("rel_user_ou_user_uuid is null");
            return (Criteria) this;
        }

        public Criteria andRelUserOuUserUuidIsNotNull() {
            addCriterion("rel_user_ou_user_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andRelUserOuUserUuidEqualTo(String value) {
            addCriterion("rel_user_ou_user_uuid =", value, "relUserOuUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuUserUuidNotEqualTo(String value) {
            addCriterion("rel_user_ou_user_uuid <>", value, "relUserOuUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuUserUuidGreaterThan(String value) {
            addCriterion("rel_user_ou_user_uuid >", value, "relUserOuUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuUserUuidGreaterThanOrEqualTo(String value) {
            addCriterion("rel_user_ou_user_uuid >=", value, "relUserOuUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuUserUuidLessThan(String value) {
            addCriterion("rel_user_ou_user_uuid <", value, "relUserOuUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuUserUuidLessThanOrEqualTo(String value) {
            addCriterion("rel_user_ou_user_uuid <=", value, "relUserOuUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuUserUuidLike(String value) {
            addCriterion("rel_user_ou_user_uuid like", value, "relUserOuUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuUserUuidNotLike(String value) {
            addCriterion("rel_user_ou_user_uuid not like", value, "relUserOuUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuUserUuidIn(List<String> values) {
            addCriterion("rel_user_ou_user_uuid in", values, "relUserOuUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuUserUuidNotIn(List<String> values) {
            addCriterion("rel_user_ou_user_uuid not in", values, "relUserOuUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuUserUuidBetween(String value1, String value2) {
            addCriterion("rel_user_ou_user_uuid between", value1, value2, "relUserOuUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuUserUuidNotBetween(String value1, String value2) {
            addCriterion("rel_user_ou_user_uuid not between", value1, value2, "relUserOuUserUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuOuUuidIsNull() {
            addCriterion("rel_user_ou_ou_uuid is null");
            return (Criteria) this;
        }

        public Criteria andRelUserOuOuUuidIsNotNull() {
            addCriterion("rel_user_ou_ou_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andRelUserOuOuUuidEqualTo(String value) {
            addCriterion("rel_user_ou_ou_uuid =", value, "relUserOuOuUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuOuUuidNotEqualTo(String value) {
            addCriterion("rel_user_ou_ou_uuid <>", value, "relUserOuOuUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuOuUuidGreaterThan(String value) {
            addCriterion("rel_user_ou_ou_uuid >", value, "relUserOuOuUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuOuUuidGreaterThanOrEqualTo(String value) {
            addCriterion("rel_user_ou_ou_uuid >=", value, "relUserOuOuUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuOuUuidLessThan(String value) {
            addCriterion("rel_user_ou_ou_uuid <", value, "relUserOuOuUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuOuUuidLessThanOrEqualTo(String value) {
            addCriterion("rel_user_ou_ou_uuid <=", value, "relUserOuOuUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuOuUuidLike(String value) {
            addCriterion("rel_user_ou_ou_uuid like", value, "relUserOuOuUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuOuUuidNotLike(String value) {
            addCriterion("rel_user_ou_ou_uuid not like", value, "relUserOuOuUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuOuUuidIn(List<String> values) {
            addCriterion("rel_user_ou_ou_uuid in", values, "relUserOuOuUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuOuUuidNotIn(List<String> values) {
            addCriterion("rel_user_ou_ou_uuid not in", values, "relUserOuOuUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuOuUuidBetween(String value1, String value2) {
            addCriterion("rel_user_ou_ou_uuid between", value1, value2, "relUserOuOuUuid");
            return (Criteria) this;
        }

        public Criteria andRelUserOuOuUuidNotBetween(String value1, String value2) {
            addCriterion("rel_user_ou_ou_uuid not between", value1, value2, "relUserOuOuUuid");
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