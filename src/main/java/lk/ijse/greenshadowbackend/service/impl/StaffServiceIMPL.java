package lk.ijse.greenshadowbackend.service.impl;

import lk.ijse.greenshadowbackend.customObj.StaffResponse;
import lk.ijse.greenshadowbackend.customObj.impl.StaffErrorResponse;
import lk.ijse.greenshadowbackend.dao.StaffDao;
import lk.ijse.greenshadowbackend.dto.impl.StaffDTO;
import lk.ijse.greenshadowbackend.entity.StaffEntity;
import lk.ijse.greenshadowbackend.exceptions.DataPersistFailedException;
import lk.ijse.greenshadowbackend.exceptions.StaffNotFound;
import lk.ijse.greenshadowbackend.service.StaffService;
import lk.ijse.greenshadowbackend.util.AppUtil;
import lk.ijse.greenshadowbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StaffServiceIMPL implements StaffService {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveStaff(StaffDTO staffDTO) {
        staffDTO.setStaffId(AppUtil.createStaffId());
        var staffEntity = mapping.convertToStaffEntity(staffDTO);
        var savedStaff = staffDao.save(staffEntity);
        if (savedStaff == null){
            throw new DataPersistFailedException("Cannot save Staff");
        }
    }
    @Override
    public List<StaffDTO> getAllStaffs() {
        List<StaffEntity> getAllStaffs = staffDao.findAll();
        return mapping.convertStaffToDTOList(getAllStaffs);
    }

    @Override
    public StaffResponse getSelectedStaff(String staffId) {
        if (staffDao.existsById(staffId)) {
            StaffEntity staffEntityByStaffId = staffDao.getReferenceById(staffId);
           return (StaffResponse) mapping.convertToStaffDTO(staffEntityByStaffId);
        } else {
            return new StaffErrorResponse(0, "Staff not Found");
        }
    }
    @Override
    public void updateStaff(String staffId, StaffDTO incomestaffDTO) {
        Optional<StaffEntity> tmpStaffEntity = staffDao.findById(staffId);

        if (!tmpStaffEntity.isPresent()) {
            throw new StaffNotFound("Staff not found");
        } else {
            StaffEntity staffEntity = tmpStaffEntity.get();

            staffEntity.setFirstName(incomestaffDTO.getFirstName());
            staffEntity.setLastName(incomestaffDTO.getLastName());
            staffEntity.setDesignation(incomestaffDTO.getDesignation());
            staffEntity.setGender(incomestaffDTO.getGender());
            staffEntity.setJoinedDate(incomestaffDTO.getJoinedDate());
            staffEntity.setDob(incomestaffDTO.getDob());
            staffEntity.setAddressLine1(incomestaffDTO.getAddressLine1());
            staffEntity.setAddressLine2(incomestaffDTO.getAddressLine2());
            staffEntity.setAddressLine3(incomestaffDTO.getAddressLine3());
            staffEntity.setAddressLine4(incomestaffDTO.getAddressLine4());
            staffEntity.setAddressLine5(incomestaffDTO.getAddressLine5());
            staffEntity.setContactNo(incomestaffDTO.getContactNo());
            staffEntity.setEmail(incomestaffDTO.getEmail());
            staffEntity.setRole(incomestaffDTO.getRole());

            staffDao.save(staffEntity);
        }
    }

}
