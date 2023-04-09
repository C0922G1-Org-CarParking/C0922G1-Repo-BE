package com.example.repository;

import com.example.dto.IParkingNewsDTO;
import com.example.model.ParkingNews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface IParkingNewsRepository extends JpaRepository<ParkingNews, Integer> {
    String GET_ALL_PARKING_NEWS = "select pn.parking_news_id as parkingNewsId, pn.title, pn.description, pn.image_url as imageUrl, pn.posting_date as postingDate " +
            "from `parking_news` pn " +
            "where pn.is_deleted = 0 and " +
            "(pn.title like concat('%', :keyword, '%') or pn.description like concat('%', :keyword, '%'))";

    String FIND_BY_ID = "select pn.parking_news_id as parkingNewsId, pn.title, pn.description, pn.image_url as imageUrl ,pn.posting_date as postingDate, pn.content " +
            "from `parking_news` pn " +
            "where pn.is_deleted = 0 and pn.parking_news_id = :id";

    @Query(value = GET_ALL_PARKING_NEWS, nativeQuery = true)
    Page<IParkingNewsDTO> findAll(Pageable pageable, @Param("keyword") String keyword);

    @Query(value = FIND_BY_ID, nativeQuery = true)
    IParkingNewsDTO findById(@Param("id") int id);

}
