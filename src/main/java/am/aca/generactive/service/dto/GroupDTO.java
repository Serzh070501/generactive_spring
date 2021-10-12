package am.aca.generactive.service.dto;

import am.aca.generactive.model.Group;
import am.aca.generactive.model.Item;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GroupDTO {
    private Long id;
    @NotBlank(message = "name must not be blank")
    private String name;
    private List<Item> items = new ArrayList<>();
    private Group parentGroup;
    private final List<Group> subGroups = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Group getParentGroup() {
        return parentGroup;
    }

    public void setParentGroup(Group parentGroup) {
        this.parentGroup = parentGroup;
    }

    public List<Group> getSubGroups() {
        return subGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupDTO groupDTO = (GroupDTO) o;
        return Objects.equals(id, groupDTO.id) && Objects.equals(items, groupDTO.items) && Objects.equals(parentGroup, groupDTO.parentGroup) && Objects.equals(subGroups, groupDTO.subGroups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, items, parentGroup, subGroups);
    }

    @Override
    public String toString() {
        return "GroupDTO{" +
                "id=" + id +
                ", items=" + items +
                ", parentGroup=" + parentGroup +
                ", subGroups=" + subGroups +
                '}';
    }
}
