package entity;

public class ItemOfClothing {
    private Integer item_id;
    private Integer item_type;
    private String item_producer_name;

    public Integer getItem_id() {
        return item_id;
    }

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public Integer getItem_type() {
        return item_type;
    }

    public void setItem_type(Integer item_type) {
        this.item_type = item_type;
    }

    public String getItem_producer_name() {
        return item_producer_name;
    }

    public void setItem_producer_name(String item_producer_name) {
        this.item_producer_name = item_producer_name;
    }

    public ItemOfClothing(Integer item_id, Integer item_type, String item_producer_name) {
        this.item_id = item_id;
        this.item_type = item_type;
        this.item_producer_name = item_producer_name;
    }

    public ItemOfClothing() {
    }
}
