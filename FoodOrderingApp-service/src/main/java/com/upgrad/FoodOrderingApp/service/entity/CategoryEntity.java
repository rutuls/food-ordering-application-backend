package com.upgrad.FoodOrderingApp.service.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="category")
@NamedQueries({
        @NamedQuery(name = "allCategories", query = "select c from CategoryEntity c ORDER BY c.category_name ASC"),
        @NamedQuery(name = "categoryById", query = "select c from CategoryEntity c where c.uuid=:catuuid")
})
public class CategoryEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "UUID")
    @Size(max = 200)
    private String uuid;

    @Column(name = "CATEGORY_NAME")
    @Size(max = 255)
    private String category_name;

    @ManyToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<RestaurantEntity> restaurant = new ArrayList<RestaurantEntity>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ItemEntity> item = new ArrayList<ItemEntity>();

    public List<RestaurantEntity> getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(List<RestaurantEntity> restaurant) {
        this.restaurant = restaurant;
    }

    public List<ItemEntity> getItem() {
        return item;
    }

    public void setItem(List<ItemEntity> item) {
        this.item = item;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public List<RestaurantEntity> getRestaurants() {
        return restaurant;
    }

    public void setRestaurants(List<RestaurantEntity> restaurants) {
        this.restaurant = restaurants;
    }
}
