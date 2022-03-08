package com.koreait.cgvproject.service.user.moive;

import com.koreait.cgvproject.dto.MovieDTO;
import com.koreait.cgvproject.dto.TrailerDTO;
import com.koreait.cgvproject.entity.Movie;
import com.koreait.cgvproject.entity.Trailer;
import com.koreait.cgvproject.repository.MovieRepository;
import com.koreait.cgvproject.repository.TrailerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserMovieService {

    private MovieRepository movieRepository;
    private TrailerRepository trailerRepository;

    public List<MovieDTO> getList(){

        List<MovieDTO> movieDTOList=new ArrayList<>();
        List<Movie> movieList =movieRepository.findAll();

        for(Movie movie  : movieList){
            movieDTOList.add(movie.toDTO());
        }
        return movieDTOList;
    }

    public TrailerDTO getTrailer(Long mcode){
        System.out.println("service에서 받은 "+mcode);
        Trailer trailer= trailerRepository.findByMcode(mcode);
        TrailerDTO trailerDTO=trailer.toDTO();
        System.out.println(trailer);
        return trailerDTO;

    }


}
