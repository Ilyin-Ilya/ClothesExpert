package entity;

public class ActivityType {
    private Integer type_id;
    private String activity_type_name;

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getActivity_type_name() {
        return activity_type_name;
    }

    public void setActivity_type_name(String activity_type_name) {
        this.activity_type_name = activity_type_name;
    }

    public ActivityType() {
    }

    public ActivityType(Integer type_id, String activity_type_name) {
        this.type_id = type_id;
        this.activity_type_name = activity_type_name;
    }
}
