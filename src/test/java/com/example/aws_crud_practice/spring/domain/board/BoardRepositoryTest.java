package com.example.aws_crud_practice.spring.domain.board;

import com.example.aws_crud_practice.board.entity.Board;
import com.example.aws_crud_practice.board.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.yml")
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @DisplayName("Board가 DB 저장 성공")
    @Test
    void saveBoard() throws Exception {
        //given
        Board board = createBoard("첫번째", "첫유저", "1234","일등이당");

        //when
        Board savedBoard = boardRepository.save(board);

        //then
        // board와 savedBoard 동일한지 확인
        Assertions.assertThat(savedBoard).isEqualTo(board);
        // 저장된 board의 id가 생성되었는지 확인
        Assertions.assertThat(savedBoard.getId()).isNotNull();
        // 한 개만 저장되었는지 확인
        Assertions.assertThat(boardRepository.count()).isEqualTo(1);
    }

    @DisplayName("지정된 id 조회 성공")
    @Test
    void getBoard() throws Exception {
        //given
        Board saveBoard2 = boardRepository.save(createBoard("제목2", "글쓴이2", "1234", "내용2"));

        //when
        Board getBoard2 = boardRepository.findById(saveBoard2.getId())
                .orElseThrow(() -> new IllegalArgumentException("지정된 board를 찾을 수 없습니다."));

        //then
        Assertions.assertThat(getBoard2).isEqualTo(saveBoard2);
        Assertions.assertThat(getBoard2.getTitle()).isEqualTo("제목2");
        Assertions.assertThat(getBoard2.getWriter()).isEqualTo("글쓴이2");
        Assertions.assertThat(getBoard2.getContents()).isEqualTo("내용2");
    }

    Board createBoard(String title, String writer, String password, String contents) {
        return Board.builder()
                .title(title)
                .writer(writer)
                .password(password)
                .contents(contents)
                .build();
    }
}
