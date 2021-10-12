package am.aca.generactive.repository;

import am.aca.generactive.model.Group;
import am.aca.generactive.model.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class GroupRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;






    public Item update(Item item) {
        Item existing = entityManager.find(Item.class, item.getId());
        existing.setName(item.getName());
        existing.setBasePrice(item.getBasePrice());

        return existing;
    }


    public Optional<Item> findById(Long id) {

        Item item = entityManager.find(Item.class, id);

        return Optional.ofNullable(item);
    }


    public List<? extends Group> getAllGroups() {

        String q = "from Group";

        List<? extends Group> groups = entityManager.createQuery(q, Group.class)
                .getResultList();

        return groups;
    }


    public boolean deleteById(Long id) {

        String q = "delete from Group i" +
                " where i.id = :id";


        int deleted = entityManager.createQuery(q)
                .setParameter("id", id)
                .executeUpdate();

        return deleted != 0;
    }


    public boolean delete(Group group) {
        entityManager.remove(group);

        return true;
    }

}
