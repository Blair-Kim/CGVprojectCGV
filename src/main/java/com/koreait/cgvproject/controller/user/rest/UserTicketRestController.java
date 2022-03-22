package com.koreait.cgvproject.controller.user.rest;

import com.koreait.cgvproject.dto.PriceDTO;
import com.koreait.cgvproject.dto.ScheduleDTO;
import com.koreait.cgvproject.service.user.schedule.UserScheduleService;
import com.koreait.cgvproject.service.user.ticket.UserTicketService;
import lombok.AllArgsConstructor;
import org.apache.catalina.util.ToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@AllArgsConstructor
public class UserTicketRestController {

    private UserScheduleService userScheduleService;
    private UserTicketService userTicketService;

    private HttpSession session;

    @PostMapping("/api/findSchedule")
    public List<ScheduleDTO> scheduleDTOList(@RequestBody ScheduleDTO scheduleDTO){
        return userScheduleService.findScheduleList(scheduleDTO.getMcode(), scheduleDTO.getTcode());
    }
    @GetMapping("/api/findSchedule")
    public List<ScheduleDTO> findAllOnlyMcode(@RequestParam Long mcode, @RequestParam String scdate,
                                              @RequestParam Long tcode){
        return userScheduleService.findAllOnlyMcode(mcode, tcode, scdate);
    }

    @GetMapping("/api/schedule/getSeatCount")
    public Long getSeatCount(@RequestParam Long hcode){
        return userScheduleService.getSeatCount(hcode);
    }

    @PostMapping("/api/ticket/getPrice")
    public PriceDTO getPrice(@RequestParam Long tcode, @RequestParam String week, @RequestParam String startTime){
        System.out.println("포스트로 들어가니"); // 작업중
        return userTicketService.getPrice(tcode, week, startTime);
    }
}
