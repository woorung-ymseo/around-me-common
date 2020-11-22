package around.me.common.api.v1.term.service;

import around.me.common.api.v1.term.repository.TermRepository;
import around.me.common.core.domain.Term;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TermService {

    private final TermRepository termRepository;

    public Term findUserId() {
        Optional<Term> term = termRepository.findById(1L);

        return term.orElse(null);
    }
}
