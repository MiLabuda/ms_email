package com.wszib.mail.adapters.out;

import com.wszib.mail.adapters.out.model.MailData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailRepository extends JpaRepository<MailData, Long> {

    Page<MailData> findAll(Pageable pageable);

}
