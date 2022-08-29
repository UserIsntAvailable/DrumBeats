using System;
using System.Collections.Generic;
using System.Text.Json;

namespace OsuFileParser {
    public static class OsuBeatmapConverter {
        public static string ToDrumBeats(OsuBeatmap beatmap) {
            var obj = new {
                Name         = beatmap.Title,
                Artist       = beatmap.Artist,
                SongFileName = beatmap.AudioFilename,
                ID           = Guid.NewGuid().ToString(),
                SetID        = Guid.NewGuid().ToString(),
                Notes        = GetNotesFromHitObjects(beatmap.HitObjects),
            };

            return JsonSerializer.Serialize(obj, new JsonSerializerOptions() {
                WriteIndented = true
            });
        }

        private static List<Object> GetNotesFromHitObjects(List<string> beatmapHitObjects) {
            var returned = new List<Object>();

            foreach(var hitObject in beatmapHitObjects) { returned.Add(GetNoteFromHitObject(hitObject)); }

            return returned;
        }

        private static object GetNoteFromHitObject(string hitObject) {
            var hoProps = hitObject.Split(",");

            return new {
                Time      = int.Parse(hoProps[2]),
                TaikoNote = 0, // I will work with circles for now
                NoteType  = GetNoteType(hoProps[4]),
                Params    = GetParams(hoProps[4]),
            };
        }
        private static int GetNoteType(string hitSoundType) {
            var p = Enum.Parse(typeof(HitSoundType), hitSoundType).ToString();

            if(p.Contains("Whistle") || p.Contains("Clap")) {
                return 1;
            }
            
            return 2;
        }
        
        private static string GetParams(string hitSoundType) {
            return Enum.Parse(typeof(HitSoundType), hitSoundType).ToString().Contains("Finish") ? "1," : "0,";
        }
    }
}
