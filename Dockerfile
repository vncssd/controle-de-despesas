FROM postgres:16

#variáveis padrão
ENV POSTGRES_USER=admin
ENV POSTRGRES_PASSWORD=admin
ENV POSTGRES_DB=controle_despesas

EXPOSE 5432