package application.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class TestEntity {
    @Id(autoincrement = true)
    private Long _id;
    @NotNull
    private String name;
    private String desc;
    @Generated(hash = 488503488)
    public TestEntity(Long _id, @NotNull String name, String desc) {
        this._id = _id;
        this.name = name;
        this.desc = desc;
    }
    @Generated(hash = 1020448049)
    public TestEntity() {
    }
    public Long get_id() {
        return this._id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
