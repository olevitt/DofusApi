package dofusapi.com.dofusapi.storage;

import dofusapi.com.dofusapi.core.Equipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Integer> {}
