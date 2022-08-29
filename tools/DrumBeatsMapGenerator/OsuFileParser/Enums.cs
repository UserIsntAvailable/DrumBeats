using System;

namespace OsuFileParser {

    [Flags]
    public enum Mods {

        NoMod          = 0,
        NoFail         = 1,
        Easy           = 2,
        TouchDevice    = 4,
        Hidden         = 8,
        HardRock       = 16,
        SuddenDeath    = 32,
        DoubleTime     = 64,
        Relax          = 128,
        HalfTime       = 256,
        NightCore      = 576,
        FlashLight     = 1024,
        Auto           = 2048,
        SpunOut        = 4096,
        AutoPilot      = 8192,
        Perfect        = 16416,
        Cinema         = 4194304,
        TargetPractice = 8388608,
        ScoreV2        = 536870912,
    }

    public enum Ruleset {

        Standard,
        Taiko,
        CatchTheBeat,
        Mania,
    }
    
    [Flags]
    internal enum HitObjectType
    {
        Circle      = 1,
        Slider      = 1 << 1,
        NewCombo    = 1 << 2,
        Spinner     = 1 << 3,
        ComboOffset = (1 << 4) | (1 << 5) | (1 << 6),
        Hold        = 1 << 7,
    }
    
    [Flags]
    internal enum HitSoundType
    {
        None    = 0,
        Normal  = 1,
        Whistle = 2,
        Finish  = 4,
        Clap    = 8,
    }

    public enum RankedStatus {

        Ranked,
        Approved,
        Loved,
        Pending,
        Graveyard,
    }
}
