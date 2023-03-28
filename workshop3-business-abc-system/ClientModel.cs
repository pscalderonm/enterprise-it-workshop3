using System.ComponentModel.DataAnnotations;

namespace AbcSystem.Crm;

public class ClientModel
{
  [Required]
  public string? Uid { get; set; }
  
  [Required]
  public string? Names {get; set;}

  [Required]
  public string? Address {get; set;}

  [Required]
  public string? Phone {get; set;}

  [Required]
  public BuyingProfileModel? BuyingProfile { get; set; }
 }

 public class BuyingProfileModel
 {
    [Required]
    public string? Channel { get; set; }
 }