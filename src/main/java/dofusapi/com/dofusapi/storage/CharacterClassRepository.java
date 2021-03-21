package dofusapi.com.dofusapi.storage;

import dofusapi.com.dofusapi.core.CharacterClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterClassRepository extends CrudRepository<CharacterClass, Integer> {}
