using System;
using System.IO;
using System.Text.Json;
using OsuFileParser;

var path    = "<MAP_PATH.osu";
var beatmap = OsuFileReader.Read(path);

File.AppendAllText(path.Replace(".osu", ".map"), OsuBeatmapConverter.ToDrumBeats(beatmap));
Console.WriteLine(JsonSerializer.Serialize(beatmap, new JsonSerializerOptions() {WriteIndented = true,}));
