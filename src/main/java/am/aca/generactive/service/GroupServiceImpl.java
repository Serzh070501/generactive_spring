package am.aca.generactive.service;

import am.aca.generactive.model.Group;
import am.aca.generactive.model.Item;
import am.aca.generactive.repository.GroupRepository;
import am.aca.generactive.service.dto.GroupDTO;
import am.aca.generactive.service.mapper.GroupDTOMapper;
import am.aca.generactive.service.mapper.ItemDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService{
    private final GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public GroupDTO create(GroupDTO groupDTO) {
        Group entity = GroupDTOMapper.mapToEntity(groupDTO);

        groupRepository.save(entity);

        return GroupDTOMapper.mapToDTO(entity).orElse(null);
    }

    @Override
    public Group update(Group group) {
        return groupRepository.save(group);
    }



    @Override
    public boolean delete(Long id) {
        if (!groupRepository.existsById(id)) {
            return false;
        }

        groupRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<GroupDTO> getGroup(Long id) {
        Optional<Group> group = groupRepository.findById(id);

        return GroupDTOMapper.mapToDTO(group.orElse(null));
    }

    @Override
    public List<? extends GroupDTO> getAll() {
      return   GroupDTOMapper.mapToDTOs(groupRepository.findAll());
    }

    @Override
    public List<? extends GroupDTO> find(String name) {
        Specification<Group> specification = Specification.where(null);

        return GroupDTOMapper
                .mapToDTOs(groupRepository
                        .find(name));    }
}
