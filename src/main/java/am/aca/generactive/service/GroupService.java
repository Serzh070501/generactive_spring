package am.aca.generactive.service;

import am.aca.generactive.model.Group;
import am.aca.generactive.model.Item;
import am.aca.generactive.service.dto.GroupDTO;
import am.aca.generactive.service.dto.ItemDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface GroupService {
    GroupDTO create(GroupDTO  groupDTO);
    Group update(Group group);
    boolean delete(Long id);
    Optional<GroupDTO> getGroup(Long id);
    List<? extends GroupDTO> getAll();
    List<? extends GroupDTO> find(String name);
}
