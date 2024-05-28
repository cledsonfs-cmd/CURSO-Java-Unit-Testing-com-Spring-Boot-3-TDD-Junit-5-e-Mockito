package br.gov.ce.sop.conserva.model.service.impl;

import br.gov.ce.sop.conserva.model.dto.views.FilterVoMedicaoAAbrirDTO;
import br.gov.ce.sop.conserva.model.entity.Medicao;
import br.gov.ce.sop.conserva.model.entity.MedicaoHistorico;
import br.gov.ce.sop.conserva.model.repository.MedicaoRepository;
import br.gov.ce.sop.conserva.model.service.MedicaoHistoricoService;
import br.gov.ce.sop.conserva.model.service.MedicaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MedicaoServiceImplTest {

    @Mock
    MedicaoRepository mokiRepository;
    @Mock
    MedicaoHistoricoService mokiMedicaoHistoricoService;

    @InjectMocks
    MedicaoServiceImpl injeMedicaoServiceImpl;

    List<FilterVoMedicaoAAbrirDTO> mokiMedicoesDTO;

    @BeforeEach
    void setUp(){

    }

    @DisplayName("Test Opening One Standard Measurement")
    @Test
    void test_Opening_One_Standard_Measurement() {

        // Given / Arrange
        mokiMedicoesDTO = new ArrayList<>();
        mokiMedicoesDTO.add(FilterVoMedicaoAAbrirDTO.builder().id(1L).nrMedicaoASerAberta(1L).build());

        List<String> mensagem = new ArrayList<>();
        mensagem.add("Medição aberta com sucesso Cod: 1");
        Medicao medicao = Medicao.builder().id(100L).nrMedicao(1L).build();
        when(mokiRepository.save(any(Medicao.class))).thenReturn(medicao);
        when(mokiMedicaoHistoricoService.save(any(MedicaoHistorico.class))).thenReturn(MedicaoHistorico.builder().build());

        //When
        List<String> mensagemRetorno =  injeMedicaoServiceImpl.abrirMedicaoPadrao(mokiMedicoesDTO);

        //Then
        assertEquals(mensagem.size(), mensagemRetorno.size());
        assertEquals(mensagem, mensagemRetorno);
    }

    @DisplayName("Test Opening Two Standard Measurement")
    @Test
    void test_Opening_Two_Standard_Measurement() {

        // Given / Arrange
        mokiMedicoesDTO = new ArrayList<>();
        mokiMedicoesDTO.add(FilterVoMedicaoAAbrirDTO.builder().id(1L).nrMedicaoASerAberta(1L).build());
        mokiMedicoesDTO.add(FilterVoMedicaoAAbrirDTO.builder().id(1L).nrMedicaoASerAberta(2L).build());

        List<String> mensagem = new ArrayList<>();
        mensagem.add("Medição aberta com sucesso Cod: 1");
        mensagem.add("Medição aberta com sucesso Cod: 2");
        
        Medicao medicao = Medicao.builder().id(100L).nrMedicao(1L).build();
        Medicao medicao2 = Medicao.builder().id(101L).nrMedicao(2L).build();
        when(mokiRepository.save(any(Medicao.class))).thenReturn(medicao).thenReturn(medicao2);
        when(mokiMedicaoHistoricoService.save(any(MedicaoHistorico.class))).thenReturn(MedicaoHistorico.builder().build());

        //When
        List<String> mensagemRetorno =  injeMedicaoServiceImpl.abrirMedicaoPadrao(mokiMedicoesDTO);

        //Then
        assertEquals(mensagem.size(), mensagemRetorno.size());
        assertEquals(mensagem, mensagemRetorno);
    }
}