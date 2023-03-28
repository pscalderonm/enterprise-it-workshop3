using Microsoft.AspNetCore.Mvc;

namespace AbcSystem.Crm;

[ApiController]
[Route("[controller]")]
public class ClientController : ControllerBase
{
  private static readonly Dictionary<string, ClientModel> InMemoryClientsRepo =
    new ();

  [HttpGet]
  public IEnumerable<ClientModel> GetAll() =>
    InMemoryClientsRepo.Keys.Select(k=>InMemoryClientsRepo[k]);
  

  [HttpGet("/{clientId}")]
  [Produces(typeof(ClientModel))]
  public IActionResult Get([FromRoute] string clientId)
  {
    if(InMemoryClientsRepo.TryGetValue(clientId, out var model))
    {
      return Ok(model);
    }
    return NotFound();
  }

  [HttpPost]
  public IActionResult Post([FromBody] ClientModel model)
  {
    if(InMemoryClientsRepo.Keys.Any(id=>id==model.Uid))
    {
      return BadRequest("Duplicated record");
    }

    InMemoryClientsRepo.Add(model.Uid!, model);
    
    return new StatusCodeResult(StatusCodes.Status201Created);
  }
}