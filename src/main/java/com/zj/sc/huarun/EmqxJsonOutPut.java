package com.zj.sc.huarun;

/**
 * @author zhoujing
 * @version 1.0
 * @since 2023/11/13 19:25
 */
public class EmqxJsonOutPut {

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    public EmqxJsonOutPut(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public EmqxJsonOutPut() {
    }

    public static EmqxJsonOutPutBuilder builder() {
        return new EmqxJsonOutPutBuilder();
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof EmqxJsonOutPut)) return false;
        final EmqxJsonOutPut other = (EmqxJsonOutPut) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EmqxJsonOutPut;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        return result;
    }

    public String toString() {
        return "EmqxJsonOutPut(name=" + this.getName() + ", type=" + this.getType() + ")";
    }

    public static class EmqxJsonOutPutBuilder {
        private String name;
        private String type;

        EmqxJsonOutPutBuilder() {
        }

        public EmqxJsonOutPutBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EmqxJsonOutPutBuilder type(String type) {
            this.type = type;
            return this;
        }

        public EmqxJsonOutPut build() {
            return new EmqxJsonOutPut(this.name, this.type);
        }

        public String toString() {
            return "EmqxJsonOutPut.EmqxJsonOutPutBuilder(name=" + this.name + ", type=" + this.type + ")";
        }
    }
}
