from fastapi import FastAPI
from fastapi.responses import Response
from starlette import status
from pydantic import BaseModel, Field

app = FastAPI()

IN_MEM_CLIENTS=dict()

class BuyingProfile(BaseModel):
  channel: str


class Client(BaseModel):
  uid: str
  names: str
  address: str
  phone: str
  buying_profile: BuyingProfile = Field(alias="buyingProfile")
  

@app.get('/')
async def root():
  return 'I am alive'


@app.get('/clients', response_model=list[Client])
async def get_all():
  return [IN_MEM_CLIENTS[x] for x in IN_MEM_CLIENTS.keys()]

@app.get('/clients/{client_id}')
async def get_client(client_id:str):
  return (IN_MEM_CLIENTS[client_id] if (client_id in IN_MEM_CLIENTS)
          else Response(status_code=status.HTTP_404_NOT_FOUND))
  
@app.post('/clients', status_code=status.HTTP_201_CREATED)
async def add_client(client:Client):
  if client.uid in IN_MEM_CLIENTS:
    return Response(status_code=status.HTTP_400_BAD_REQUEST, content='Duplicated client')
  IN_MEM_CLIENTS[client.uid] = client