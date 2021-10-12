package am.aca.generactive.service.mapper;

import am.aca.generactive.model.Group;
import am.aca.generactive.service.dto.GroupDTO;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class GroupDTOMapper {
    public static List<GroupDTO> mapToDTOs(Collection<? extends Group> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return new ArrayList<>();
        }

        List<GroupDTO> rv = new ArrayList<>();

        for (Group entity : entities) {
            rv.add(mapToDTO(entity).orElse(null));
        }

        return rv;
    }

    public static Optional<GroupDTO> mapToDTO(Group entity) {
        if (entity == null) {
            return Optional.empty();
        }

        GroupDTO dto = new GroupDTO();
        dto.setId(entity.getId());
        dto.setParentGroup(entity.getParentGroup());
        dto.setItems(entity.getItems());


        return Optional.of(dto);
    }

    public static Group mapToEntity(GroupDTO dto) {
        if (dto == null) {
            return null;
        }

        Group entity = new Group();
        entity.setId(dto.getId());
        entity.setItems(dto.getItems());
        entity.setName(dto.getName());



        return entity;
    }
}
