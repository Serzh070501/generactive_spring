package am.aca.generactive.controller;

import am.aca.generactive.model.Group;
import am.aca.generactive.service.GroupService;
import am.aca.generactive.service.GroupServiceImpl;
import am.aca.generactive.service.dto.GroupDTO;
import am.aca.generactive.service.dto.ItemDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    private final GroupServiceImpl groupService;

    public GroupController(GroupServiceImpl groupService) {
        this.groupService = groupService;
    }
    @GetMapping
    public List<? extends GroupDTO> getAll() {
        return groupService.getAll();
    }

    @GetMapping("/search")
    public List<? extends GroupDTO> search(@RequestParam String name) {
        return groupService.find(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDTO> getGroup(@PathVariable Long id) {

        return ResponseEntity.of(groupService.getGroup(id));
    }

    @PostMapping
    public @ResponseBody
    GroupDTO create(@RequestBody @Valid GroupDTO groupDTO) {

        return groupService.create(groupDTO);
    }
}
