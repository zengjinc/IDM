package com.ssm.pojo;

import java.util.ArrayList;
import java.util.List;

public class AccessControlAssignExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccessControlAssignExample() {
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

        public Criteria andAssgUserUuidIsNull() {
            addCriterion("assg_user_uuid is null");
            return (Criteria) this;
        }

        public Criteria andAssgUserUuidIsNotNull() {
            addCriterion("assg_user_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andAssgUserUuidEqualTo(String value) {
            addCriterion("assg_user_uuid =", value, "assgUserUuid");
            return (Criteria) this;
        }

        public Criteria andAssgUserUuidNotEqualTo(String value) {
            addCriterion("assg_user_uuid <>", value, "assgUserUuid");
            return (Criteria) this;
        }

        public Criteria andAssgUserUuidGreaterThan(String value) {
            addCriterion("assg_user_uuid >", value, "assgUserUuid");
            return (Criteria) this;
        }

        public Criteria andAssgUserUuidGreaterThanOrEqualTo(String value) {
            addCriterion("assg_user_uuid >=", value, "assgUserUuid");
            return (Criteria) this;
        }

        public Criteria andAssgUserUuidLessThan(String value) {
            addCriterion("assg_user_uuid <", value, "assgUserUuid");
            return (Criteria) this;
        }

        public Criteria andAssgUserUuidLessThanOrEqualTo(String value) {
            addCriterion("assg_user_uuid <=", value, "assgUserUuid");
            return (Criteria) this;
        }

        public Criteria andAssgUserUuidLike(String value) {
            addCriterion("assg_user_uuid like", value, "assgUserUuid");
            return (Criteria) this;
        }

        public Criteria andAssgUserUuidNotLike(String value) {
            addCriterion("assg_user_uuid not like", value, "assgUserUuid");
            return (Criteria) this;
        }

        public Criteria andAssgUserUuidIn(List<String> values) {
            addCriterion("assg_user_uuid in", values, "assgUserUuid");
            return (Criteria) this;
        }

        public Criteria andAssgUserUuidNotIn(List<String> values) {
            addCriterion("assg_user_uuid not in", values, "assgUserUuid");
            return (Criteria) this;
        }

        public Criteria andAssgUserUuidBetween(String value1, String value2) {
            addCriterion("assg_user_uuid between", value1, value2, "assgUserUuid");
            return (Criteria) this;
        }

        public Criteria andAssgUserUuidNotBetween(String value1, String value2) {
            addCriterion("assg_user_uuid not between", value1, value2, "assgUserUuid");
            return (Criteria) this;
        }

        public Criteria andAssgObjCodeIsNull() {
            addCriterion("assg_obj_code is null");
            return (Criteria) this;
        }

        public Criteria andAssgObjCodeIsNotNull() {
            addCriterion("assg_obj_code is not null");
            return (Criteria) this;
        }

        public Criteria andAssgObjCodeEqualTo(Integer value) {
            addCriterion("assg_obj_code =", value, "assgObjCode");
            return (Criteria) this;
        }

        public Criteria andAssgObjCodeNotEqualTo(Integer value) {
            addCriterion("assg_obj_code <>", value, "assgObjCode");
            return (Criteria) this;
        }

        public Criteria andAssgObjCodeGreaterThan(Integer value) {
            addCriterion("assg_obj_code >", value, "assgObjCode");
            return (Criteria) this;
        }

        public Criteria andAssgObjCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("assg_obj_code >=", value, "assgObjCode");
            return (Criteria) this;
        }

        public Criteria andAssgObjCodeLessThan(Integer value) {
            addCriterion("assg_obj_code <", value, "assgObjCode");
            return (Criteria) this;
        }

        public Criteria andAssgObjCodeLessThanOrEqualTo(Integer value) {
            addCriterion("assg_obj_code <=", value, "assgObjCode");
            return (Criteria) this;
        }

        public Criteria andAssgObjCodeIn(List<Integer> values) {
            addCriterion("assg_obj_code in", values, "assgObjCode");
            return (Criteria) this;
        }

        public Criteria andAssgObjCodeNotIn(List<Integer> values) {
            addCriterion("assg_obj_code not in", values, "assgObjCode");
            return (Criteria) this;
        }

        public Criteria andAssgObjCodeBetween(Integer value1, Integer value2) {
            addCriterion("assg_obj_code between", value1, value2, "assgObjCode");
            return (Criteria) this;
        }

        public Criteria andAssgObjCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("assg_obj_code not between", value1, value2, "assgObjCode");
            return (Criteria) this;
        }

        public Criteria andAssgRoleCodeIsNull() {
            addCriterion("assg_role_code is null");
            return (Criteria) this;
        }

        public Criteria andAssgRoleCodeIsNotNull() {
            addCriterion("assg_role_code is not null");
            return (Criteria) this;
        }

        public Criteria andAssgRoleCodeEqualTo(Integer value) {
            addCriterion("assg_role_code =", value, "assgRoleCode");
            return (Criteria) this;
        }

        public Criteria andAssgRoleCodeNotEqualTo(Integer value) {
            addCriterion("assg_role_code <>", value, "assgRoleCode");
            return (Criteria) this;
        }

        public Criteria andAssgRoleCodeGreaterThan(Integer value) {
            addCriterion("assg_role_code >", value, "assgRoleCode");
            return (Criteria) this;
        }

        public Criteria andAssgRoleCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("assg_role_code >=", value, "assgRoleCode");
            return (Criteria) this;
        }

        public Criteria andAssgRoleCodeLessThan(Integer value) {
            addCriterion("assg_role_code <", value, "assgRoleCode");
            return (Criteria) this;
        }

        public Criteria andAssgRoleCodeLessThanOrEqualTo(Integer value) {
            addCriterion("assg_role_code <=", value, "assgRoleCode");
            return (Criteria) this;
        }

        public Criteria andAssgRoleCodeIn(List<Integer> values) {
            addCriterion("assg_role_code in", values, "assgRoleCode");
            return (Criteria) this;
        }

        public Criteria andAssgRoleCodeNotIn(List<Integer> values) {
            addCriterion("assg_role_code not in", values, "assgRoleCode");
            return (Criteria) this;
        }

        public Criteria andAssgRoleCodeBetween(Integer value1, Integer value2) {
            addCriterion("assg_role_code between", value1, value2, "assgRoleCode");
            return (Criteria) this;
        }

        public Criteria andAssgRoleCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("assg_role_code not between", value1, value2, "assgRoleCode");
            return (Criteria) this;
        }

        public Criteria andAssgScpCodeIsNull() {
            addCriterion("assg_scp_code is null");
            return (Criteria) this;
        }

        public Criteria andAssgScpCodeIsNotNull() {
            addCriterion("assg_scp_code is not null");
            return (Criteria) this;
        }

        public Criteria andAssgScpCodeEqualTo(Integer value) {
            addCriterion("assg_scp_code =", value, "assgScpCode");
            return (Criteria) this;
        }

        public Criteria andAssgScpCodeNotEqualTo(Integer value) {
            addCriterion("assg_scp_code <>", value, "assgScpCode");
            return (Criteria) this;
        }

        public Criteria andAssgScpCodeGreaterThan(Integer value) {
            addCriterion("assg_scp_code >", value, "assgScpCode");
            return (Criteria) this;
        }

        public Criteria andAssgScpCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("assg_scp_code >=", value, "assgScpCode");
            return (Criteria) this;
        }

        public Criteria andAssgScpCodeLessThan(Integer value) {
            addCriterion("assg_scp_code <", value, "assgScpCode");
            return (Criteria) this;
        }

        public Criteria andAssgScpCodeLessThanOrEqualTo(Integer value) {
            addCriterion("assg_scp_code <=", value, "assgScpCode");
            return (Criteria) this;
        }

        public Criteria andAssgScpCodeIn(List<Integer> values) {
            addCriterion("assg_scp_code in", values, "assgScpCode");
            return (Criteria) this;
        }

        public Criteria andAssgScpCodeNotIn(List<Integer> values) {
            addCriterion("assg_scp_code not in", values, "assgScpCode");
            return (Criteria) this;
        }

        public Criteria andAssgScpCodeBetween(Integer value1, Integer value2) {
            addCriterion("assg_scp_code between", value1, value2, "assgScpCode");
            return (Criteria) this;
        }

        public Criteria andAssgScpCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("assg_scp_code not between", value1, value2, "assgScpCode");
            return (Criteria) this;
        }

        public Criteria andAssgDescIsNull() {
            addCriterion("assg_desc is null");
            return (Criteria) this;
        }

        public Criteria andAssgDescIsNotNull() {
            addCriterion("assg_desc is not null");
            return (Criteria) this;
        }

        public Criteria andAssgDescEqualTo(String value) {
            addCriterion("assg_desc =", value, "assgDesc");
            return (Criteria) this;
        }

        public Criteria andAssgDescNotEqualTo(String value) {
            addCriterion("assg_desc <>", value, "assgDesc");
            return (Criteria) this;
        }

        public Criteria andAssgDescGreaterThan(String value) {
            addCriterion("assg_desc >", value, "assgDesc");
            return (Criteria) this;
        }

        public Criteria andAssgDescGreaterThanOrEqualTo(String value) {
            addCriterion("assg_desc >=", value, "assgDesc");
            return (Criteria) this;
        }

        public Criteria andAssgDescLessThan(String value) {
            addCriterion("assg_desc <", value, "assgDesc");
            return (Criteria) this;
        }

        public Criteria andAssgDescLessThanOrEqualTo(String value) {
            addCriterion("assg_desc <=", value, "assgDesc");
            return (Criteria) this;
        }

        public Criteria andAssgDescLike(String value) {
            addCriterion("assg_desc like", value, "assgDesc");
            return (Criteria) this;
        }

        public Criteria andAssgDescNotLike(String value) {
            addCriterion("assg_desc not like", value, "assgDesc");
            return (Criteria) this;
        }

        public Criteria andAssgDescIn(List<String> values) {
            addCriterion("assg_desc in", values, "assgDesc");
            return (Criteria) this;
        }

        public Criteria andAssgDescNotIn(List<String> values) {
            addCriterion("assg_desc not in", values, "assgDesc");
            return (Criteria) this;
        }

        public Criteria andAssgDescBetween(String value1, String value2) {
            addCriterion("assg_desc between", value1, value2, "assgDesc");
            return (Criteria) this;
        }

        public Criteria andAssgDescNotBetween(String value1, String value2) {
            addCriterion("assg_desc not between", value1, value2, "assgDesc");
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