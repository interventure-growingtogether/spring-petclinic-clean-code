package org.springframework.samples.petclinic.vet;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2019-03-23
 */
@Service
public class VetService {

    private VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    public List<VetView> findVets() {
        return vetRepository.findAll().stream().map(vet -> new VetView(vet)).collect(Collectors.toList());
    }
}
