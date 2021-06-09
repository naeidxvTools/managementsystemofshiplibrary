package net.imwork.zhanlong.msosl.category.model;

import java.util.Set;

/**
 * @author Administrator
 */
@SuppressWarnings("all")
public class Category
{
    private String cid;//主键
    private String cname;//分类名称
    private Category parent;//父分类
    private String desc;//分类描述
    private Set<Category> children;//子分类

    @Override
    public String toString()
    {
        return "Category{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", parent=" + parent +
                ", desc='" + desc + '\'' +
                '}';
    }

    public String getCid()
    {
        return cid;
    }

    public void setCid(String cid)
    {
        this.cid = cid;
    }

    public String getCname()
    {
        return cname;
    }

    public void setCname(String cname)
    {
        this.cname = cname;
    }

    public Category getParent()
    {
        return parent;
    }

    public void setParent(Category parent)
    {
        this.parent = parent;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public Set<Category> getChildren()
    {
        return children;
    }

    public void setChildren(Set<Category> children)
    {
        this.children = children;
    }
}
