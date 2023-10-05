package com.group.imageapp.controller.image;

import com.group.imageapp.domain.image.Image;
import com.group.imageapp.dto.image.ImageRequest;
import com.group.imageapp.dto.image.response.ImageResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@RestController
public class ImageController {
    private final List<Image> images = new ArrayList<>();

    private final JdbcTemplate jdbcTemplate;

    public ImageController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @GetMapping("/Image")
    public List<ImageResponse> getImages(@ModelAttribute ImageRequest request){

        String sql = "SELECT * FROM image";

        if(request.getRandomOrNot()){
            sql += " ORDER BY RAND() LIMIT "+request.getNum();
        }else{
            sql += " LIMIT "+ request.getNum();
        }

        return jdbcTemplate.query(sql, new RowMapper<ImageResponse>(){
            public ImageResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                long id = rs.getLong("id");
                String imgname = rs.getString("imgname");
                String url = rs.getString("url");
                return new ImageResponse(id, imgname, url);
            }
        });
    }

}
