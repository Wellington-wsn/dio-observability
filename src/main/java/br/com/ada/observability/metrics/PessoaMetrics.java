package br.com.ada.observability.metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PessoaMetrics {  //métrica personalizada / custumizada

    private final Counter pessoaMaioridade;

    @Autowired
    public PessoaMetrics(MeterRegistry registry){
        pessoaMaioridade = Counter.builder("pessoa_maioridade").description("Métrica destinada a observar a quantidade de pessoas cadastradas com maioridade.").register(registry);
    }

    public void incrementPessoaMaioridadeCounter(){  // Metodo que vai fazer o almento da métrica
        pessoaMaioridade.increment();
    }
}
