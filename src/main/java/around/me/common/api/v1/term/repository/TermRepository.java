package around.me.common.api.v1.term.repository;

import around.me.common.core.domain.Term;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TermRepository extends JpaRepository<Term, Long> {

    Optional<Term> findByTermNo(long l);
}


