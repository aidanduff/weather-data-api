export function getSeasonalPrecipitation(items) {
  const seasons = [0, 0, 0, 0];

  items.forEach((item) => {
    switch (item.month) {
      case "Dec":
      case "Jan":
      case "Feb":
        seasons[0] += item.rain;
        break;
      case "Mar":
      case "Apr":
      case "May":
        seasons[1] += item.rain;
        break;
      case "Jun":
      case "Jul":
      case "Aug":
        seasons[2] += item.rain;
        break;
      case "Sep":
      case "Oct":
      case "Nov":
        seasons[3] += item.rain;
        break;
      default:
        console.log("no match");
    }
  });

  return seasons;
}
