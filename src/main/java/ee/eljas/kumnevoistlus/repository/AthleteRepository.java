package ee.eljas.kumnevoistlus.repository;

import ee.eljas.kumnevoistlus.dto.AthleteDto;
import ee.eljas.kumnevoistlus.entity.Athlete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {

    @Query("""
            SELECT new ee.eljas.kumnevoistlus.dto.AthleteDto(
                a.id,
                a.name,
                a.country,
                COALESCE(SUM(r.points), 0)
            )
            FROM Athlete a
            LEFT JOIN DecathlonResult r ON r.athlete = a
            WHERE (:country IS NULL OR :country = '' OR LOWER(a.country) = LOWER(:country))
            GROUP BY a.id, a.name, a.country
            ORDER BY COALESCE(SUM(r.points), 0) DESC
            """)
    Page<AthleteDto> findAthletesOrderByPointsDesc(@Param("country") String country, Pageable pageable);

    @Query("""
            SELECT new ee.eljas.kumnevoistlus.dto.AthleteDto(
                a.id,
                a.name,
                a.country,
                COALESCE(SUM(r.points), 0)
            )
            FROM Athlete a
            LEFT JOIN DecathlonResult r ON r.athlete = a
            WHERE (:country IS NULL OR :country = '' OR LOWER(a.country) = LOWER(:country))
            GROUP BY a.id, a.name, a.country
            ORDER BY COALESCE(SUM(r.points), 0) ASC
            """)
    Page<AthleteDto> findAthletesOrderByPointsAsc(@Param("country") String country, Pageable pageable);
}