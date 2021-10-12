package am.aca.generactive.repository;

import am.aca.generactive.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface GroupRepository extends JpaRepository<Group, Long>, JpaSpecificationExecutor<Group> {

    @Query("select i from Group i join fetch i.items" +
            " where lower(i.name) = lower(:name)")
    Collection<? extends Group> find(@Param("name") String name);


}
