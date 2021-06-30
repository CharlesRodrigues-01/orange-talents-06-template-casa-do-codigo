package br.com.zupacademy.charlesRodrigues.casadocodigo.validation;

import br.com.zupacademy.charlesRodrigues.casadocodigo.requestDto.ClienteRequestDto;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class ClientGroupSequenceProvider implements DefaultGroupSequenceProvider<ClienteRequestDto> {

    @Override
    public List<Class<?>> getValidationGroups(ClienteRequestDto clienteRequestDto) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(ClienteRequestDto.class);

        if(pessoaFisicaSelecionada(clienteRequestDto)) {
            groups.add(clienteRequestDto.getTipo().getGroup());
        }
           return groups;
        }

        protected boolean pessoaFisicaSelecionada(ClienteRequestDto requestDto) {
        return requestDto != null && requestDto.getTipo() != null;
    }
}
