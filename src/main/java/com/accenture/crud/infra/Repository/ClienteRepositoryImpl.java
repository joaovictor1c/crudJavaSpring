package com.accenture.crud.infra.Repository;

import com.accenture.crud.entity.Cliente;
import com.accenture.crud.repository.ClienteRepositoryQueries;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepositoryImpl implements ClienteRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cliente> pesquisa(String nome, String cpfCnpj, String cidade, String uf) {
        System.out.println(nome + cidade + cpfCnpj + uf);


        var builder = manager.getCriteriaBuilder();
        var criteria = builder.createQuery(Cliente.class);
        var root = criteria.from(Cliente.class);

        var predicates = new ArrayList<Predicate>();

        if (StringUtils.hasText(nome)) {
            predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
        }

        if (StringUtils.hasText(cidade)) {
            predicates.add(builder.like(root.get("cidade"), "%" + cidade + "%"));
        }
        if (StringUtils.hasText(uf)) {
            predicates.add(builder.like(root.get("uf"), uf ));
        }

        if (StringUtils.hasText(cpfCnpj)) {
            predicates.add(builder.like(root.get("cpfCnpj"), cpfCnpj));
        }

        criteria.where(predicates.toArray(new Predicate[0]));

        var query = manager.createQuery(criteria);
        return query.getResultList();
    }


}
