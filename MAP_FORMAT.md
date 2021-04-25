# .map (file format)

`.map` files format are based from [.osu files](https://github.com/ppy/osu-wiki/blob/master/wiki/osu!_File_Formats/Osu_(file_format)/en.md) but with some differences.

## Structure

`.map` files are `.json` structure files with the following fields:

| Field | Value Type | Description |
| :-- | :-- | :-- |
| `Name` | String | The name of the map. It can be anything, but most likely it will be the song name. |
| `Artist` | String | The name of the artist that created the song. |
| `SongFileName` | String | The song filename. |
| `BackgroundFileName` | String | The background image filename. |
| `ID` | String | The map ID. Only one `.map` can have that ID |
| `SetID` | String | The map set ID. All the `.map` files that are part of the same **set** will have the same map set ID |
| `Notes` | Note.Array | The notes that will appear on the map. |

## Note format
| Field | Value Type | Description |
| :-- | :-- | :-- |
| `Time` | Integer | Time when the object is to be hit, in milliseconds from the beginning of the map audio. |
| `Type` | Integer | Note type ( `1` = Circle, `2` = Slider, `4` = Spinner ) |
| `ColorType` | Integer | Note color type ( `1` = Kat [ normally blue notes ], `2` = Don [ normally red notes ], `3` = Mix [ any color ] ) |
| `Params` | String | Comma separated extra parameters that will change depending on the note `type` |

## Extra parameters

### Circle
| Param | Value Type | Description |
| :-- | :-- | :-- |
| `SizeType` | 0 or 1 | Circle size ( `0` = small circle, `1` = big circle ) |

### Slider
| Param | Value Type | Description |
| :-- | :-- | :-- |
| `SizeType` | 0 or 1 | Slider size ( `0` = small slider, `1` = big slider ) |
| `EndTime` | Integer | End time of the hold, in milliseconds from the beginning of the map audio. |

### Spinner
| Param | Value Type | Description |
| :-- | :-- | :-- |
| `EndTime` | Integer | End time of the spinner, in milliseconds from the beginning of the map audio. |
