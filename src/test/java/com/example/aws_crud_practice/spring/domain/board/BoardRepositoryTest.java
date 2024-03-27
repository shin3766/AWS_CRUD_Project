package com.example.aws_crud_practice.spring.domain.board;

import com.example.aws_crud_practice.board.entity.Board;
import com.example.aws_crud_practice.board.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @DisplayName("Board가 DB 저장 성공")
    @Test
    void saveBoard() throws Exception {
        //given
        Board board = createBoard("첫번째", "첫유저", "일등이당");

        //when
        Board saveBoard = boardRepository.save(board);

        //then
        //board와 saveBoard 동일 확인
        Assertions.assertThat(board).isSameAs(saveBoard);
        //saveBoard id 생성 확인
        Assertions.assertThat(board.getId()).isNotNull();
        //board와 saveBoard 제목 동일 확인
        Assertions.assertThat(board.getTitle()).isEqualTo(saveBoard.getTitle());
        //한 개만 저장됐는지 확인
        Assertions.assertThat(boardRepository.count()).isEqualTo(1);
    }

    @DisplayName("지정된 id 조회 성공")
    @Test
    void getBoard() throws Exception {
        //given
        Board saveBoard1 = boardRepository.save(createBoard("제목", "글쓴이", "내용"));
        Board saveBoard2 = boardRepository.save(createBoard("제목2", "글쓴이2", "내용2"));

        //when
        Board getBoard1 = boardRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("지정된 board를 찾을 수 없습니다."));
        Board getBoard2 = boardRepository.findById(2L)
                .orElseThrow(() -> new IllegalArgumentException("지정된 board를 찾을 수 없습니다."));

        //then
        Assertions.assertThat(getBoard1).isSameAs(saveBoard1);
        Assertions.assertThat(getBoard1.getTitle()).isEqualTo("제목");
        Assertions.assertThat(getBoard1.getWriter()).isEqualTo("글쓴이");
        Assertions.assertThat(getBoard1.getContents()).isEqualTo("내용");

        Assertions.assertThat(getBoard2).isSameAs(saveBoard2);
        Assertions.assertThat(getBoard2.getTitle()).isEqualTo("제목2");
        Assertions.assertThat(getBoard2.getWriter()).isEqualTo("글쓴이2");
        Assertions.assertThat(getBoard2.getContents()).isEqualTo("내용2");

    }

    Board createBoard(String title, String writer, String contents) {
        return Board.builder()
                .title(title)
                .writer(writer)
                .contents(contents)
                .build();
    }
}
