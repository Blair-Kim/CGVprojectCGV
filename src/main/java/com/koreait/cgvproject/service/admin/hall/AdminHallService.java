package com.koreait.cgvproject.service.admin.hall;

import com.koreait.cgvproject.dto.HallDTO;
import com.koreait.cgvproject.entity.Hall;
import com.koreait.cgvproject.repository.HallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminHallService {
    private HallRepository hallRepository;

    public AdminHallService(HallRepository hallRepository){
        this.hallRepository=hallRepository;
    }

    @Transactional
    public Long savePost(HallDTO hallDTO){
        return hallRepository.save(hallDTO.toEntity()).getHcode();
    }

    @Transactional
    public List<HallDTO> getHallList(){
        List<Hall> hallList = hallRepository.findAll();
        List<HallDTO> hallDTOList = new ArrayList<>();

        for(Hall hall : hallList){
            HallDTO hallDTO = HallDTO.builder().hcode(hall.getHcode()).tcode(hall.getTcode()).location(hall.getLocation())
                    .hname(hall.getHname()).build();
            hallDTOList.add(hallDTO);
        }
        return hallDTOList;
    }
}