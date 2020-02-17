package alexrm84.services;

import alexrm84.entities.DAO.RoleDAO;
import alexrm84.entities.Role;
import alexrm84.repositories.RoleRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class RoleService {

    @Inject
    private RoleRepository roleRepository;

    public void insert(RoleDAO roleDAO){
        roleRepository.insert(convertFromDao(roleDAO));
    }

    public void update(RoleDAO roleDAO){
        roleRepository.update(convertFromDao(roleDAO));
    }

    public void delete(Long id){
        roleRepository.delete(id);
    }

    public RoleDAO findById(Long id){
        return convertToDao(roleRepository.findById(id));
    }

    public List<RoleDAO> findAll(){
        return roleRepository.findAll().stream().map(u -> convertToDao(u)).collect(Collectors.toList());
    }

    public RoleDAO findByName(String name){
        return convertToDao(roleRepository.findByName(name));
    }

    public RoleDAO convertToDao(Role role){
        return new RoleDAO(role.getId(), role.getName());
    }

    public Role convertFromDao(RoleDAO roleDAO) {
        return new Role(roleDAO.getId(), roleDAO.getName());
    }
}
