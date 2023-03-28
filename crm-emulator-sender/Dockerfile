FROM alpine AS base
RUN apk --update add curl jq

FROM base
WORKDIR /app
COPY ["executor.sh", "MOCK_DATA.json", "/app/"]
RUN chmod +x executor.sh
ENTRYPOINT [ "/bin/sh", "executor.sh" ]