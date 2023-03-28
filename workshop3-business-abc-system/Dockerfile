FROM mcr.microsoft.com/dotnet/sdk:7.0 as build-env
WORKDIR /src
COPY *.csproj .
RUN dotnet restore
COPY . .
RUN dotnet publish -c Release -o /publish

FROM mcr.microsoft.com/dotnet/aspnet:7.0 as runtime
ARG PORT_NUMBER=5000
WORKDIR /publish
COPY --from=build-env /publish .
ENV ASPNETCORE_URLS=http://+:${PORT_NUMBER}
EXPOSE ${PORT_NUMBER}
ENTRYPOINT ["dotnet", "workshop3-business-abc-system.dll"]